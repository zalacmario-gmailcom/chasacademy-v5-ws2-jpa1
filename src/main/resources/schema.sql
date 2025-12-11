drop table if exists post_comments;
drop table if exists comment;
drop table if exists post;
create table post (
    post_id bigint generated always as identity primary key,
    title varchar(128) not null,
    posttext text not null,
    author varchar(32) not null,
    publish_date timestamp default now(),
    create_date timestamp default now()
);
create table comment (
    comment_id bigint generated always as identity primary key,
    title varchar(64) not null,
    comment text not null,
    comment_date timestamp default now(),
    is_inappropriate boolean default false
);
create table post_comments (
    comment_id int not null references comment(comment_id),
    post_id int not null references post(post_id),
    primary key(comment_id, post_id)
);
insert into post(
        title,
        posttext,
        author,
        publish_date,
        create_date
    )
values(
        'Första inlägget',
        'I en enkel bloggdatabas.',
        'Admin',
        now(),
        now() - INTERVAL '2 days'
    );
insert into comment(title, comment)
values('Bra jobbat', 'Fantastisk databas'),
    ('God mat', 'Lussebullar är goda');
insert into post_comments
values(1, 1),
    (2, 1);