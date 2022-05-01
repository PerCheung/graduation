create table admin_user
(
    user_id     varchar(15)   not null comment '管理员账号'
        primary key,
    password    varchar(32)   not null comment '管理员密码',
    role        int           not null comment '角色（管理员为0，教师为1，学生为2）',
    username    varchar(12)   not null comment '管理员姓名',
    user_title  varchar(20)   not null comment '管理员职称',
    create_time datetime      null comment '创建时间',
    update_time datetime      null comment '修改时间',
    deleted     int default 0 not null comment '逻辑删除'
)
    comment '管理员';

create table announcement
(
    announcement_id    int auto_increment comment '毕业论文编号'
        primary key,
    announcement_title varchar(30)   not null comment '公告标题',
    announcement_main  varchar(255)  not null comment '公告内容',
    user_id            varchar(15)   not null comment '管理员账号',
    create_time        datetime      null comment '创建时间',
    update_time        datetime      null comment '修改时间',
    deleted            int default 0 not null comment '逻辑删除'
)
    comment '公告';

create table documentation
(
    student_id             varchar(14)   not null comment '学生学号'
        primary key,
    documentation_original varchar(255)  not null comment '过程文档文件原始名称',
    documentation_name     varchar(255)  not null comment '过程文档文件名称',
    create_time            datetime      null comment '创建时间',
    update_time            datetime      null comment '修改时间',
    deleted                int default 0 not null comment '逻辑删除'
)
    comment '过程文档';

create table reply
(
    student_id      varchar(14)   not null comment '学生学号'
        primary key,
    teacher_id      varchar(14)   not null comment '教师工号',
    thesis_original varchar(255)  not null comment '论文文件原始名称',
    thesis_name     varchar(255)  not null comment '毕业论文文件名称',
    score           int default 0 not null comment '得分',
    create_time     datetime      null comment '创建时间',
    update_time     datetime      null comment '修改时间',
    deleted         int default 0 not null comment '逻辑删除'
)
    comment '答辩';

create table student
(
    student_id      varchar(14)             not null comment '学生学号'
        primary key,
    password        varchar(32)             not null comment '学生密码',
    role            int                     not null comment '角色（管理员为0，教师为1，学生为2）',
    student_name    varchar(12)             not null comment '学生姓名',
    student_college varchar(20)             not null comment '学生院系',
    student_major   varchar(20)             not null comment '学生专业',
    sex             varchar(1)  default '男' not null comment '性别',
    student_phone   varchar(11) default '0' null comment '学生电话',
    student_email   varchar(30) default '0' null comment '学生邮箱',
    teacher_id      varchar(14) default '0' null comment '教师工号',
    topic_id        int         default 0   null comment '课题编号',
    create_time     datetime                null comment '创建时间',
    update_time     datetime                null comment '修改时间',
    deleted         int         default 0   not null comment '逻辑删除'
)
    comment '学生';

create table teacher
(
    teacher_id      varchar(14)             not null comment '教师工号'
        primary key,
    password        varchar(32)             not null comment '教师密码',
    role            int                     not null comment '角色（管理员为0，教师为1，学生为2）',
    teacher_name    varchar(12)             not null comment '教师姓名',
    teacher_college varchar(20)             not null comment '教师院系',
    teacher_major   varchar(20)             not null comment '教师专业',
    sex             varchar(1)  default '男' not null comment '性别',
    teacher_title   varchar(20)             not null comment '教师职称',
    teacher_phone   varchar(11) default '0' null comment '教师电话',
    teacher_email   varchar(30) default '0' null comment '教师邮箱',
    create_time     datetime                null comment '创建时间',
    update_time     datetime                null comment '修改时间',
    deleted         int         default 0   not null comment '逻辑删除'
)
    comment '教师';

create table thesis
(
    student_id      varchar(14)   not null comment '学生学号'
        primary key,
    thesis_original varchar(255)  not null comment '论文文件原始名称',
    thesis_name     varchar(255)  not null comment '毕业论文文件名称',
    state           int default 0 not null comment '状态（0表示未审核，1表示通过，2表示不通过）',
    create_time     datetime      null comment '创建时间',
    update_time     datetime      null comment '修改时间',
    reply           int default 0 not null comment '是否分配答辩',
    score           int default 0 not null
)
    comment '毕业论文';

create table topic
(
    topic_id     int auto_increment comment '课题编号'
        primary key,
    topic_name   varchar(50)              not null comment '课题名称',
    topic_type   int          default 0   not null comment '课题类型（0表示其他，1表示科学技术，2表示生产实践）',
    topic_source int          default 0   not null comment '课题来源（0表示实习，1表示院系发布）',
    topic_main   varchar(255) default '0' not null comment '课题主要内容',
    state        int          default 0   not null comment '状态（0表示未审核，1表示通过，2表示不通过）',
    teacher_id   varchar(14)              not null comment '教师工号',
    student_id   varchar(14)  default '0' null comment '学生学号',
    create_time  datetime                 null comment '创建时间',
    update_time  datetime                 null comment '修改时间',
    deleted      int          default 0   not null comment '逻辑删除',
    constraint topic_name
        unique (topic_name)
)
    comment '课题';


