CREATE TABLE IF NOT EXISTS todo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT false
);
