create table if not exists currency (
    id UUID primary key,
    name VARCHAR(45),
    code VARCHAR(45),
    createdAt TIMESTAMP
);