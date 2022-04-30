package edu.graduation.util;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author Peter Cheung
 * @date 2022/4/30 14:25
 */
@Component("minIoUtil")
public class MinIoUtil {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    /**
     * 注入minio 客户端
     */
    private MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 上传文件
     */
    public String upload(MultipartFile file) {
        //获取上传文件的名称
        String fileName = file.getOriginalFilename();
        //1. 在文件名称里面添加随机唯一值，让每个文件都不一样
        //2. 把文件按照日期进行分类
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //DateTime是org.joda.time包下的
        fileName = new DateTime().toString("yyyy-MM-dd") + "(" + uuid.substring(16) + ")-" + fileName;
        try {
            PutObjectArgs objectArgs = PutObjectArgs.builder().object(fileName)
                    .bucket(bucketName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), -1).build();
            minioClient().putObject(objectArgs);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 下载文件
     */
    public void download(String filename, HttpServletResponse res) {
        GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(bucketName)
                .object(filename).build();
        try (GetObjectResponse response = minioClient().getObject(objectArgs)) {
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()) {
                while ((len = response.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.flush();
                byte[] bytes = os.toByteArray();
                res.setCharacterEncoding("utf-8");
                res.setContentType("application/force-download");// 设置强制下载不打开
                res.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "UTF-8"));
                try (ServletOutputStream stream = res.getOutputStream()) {
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
