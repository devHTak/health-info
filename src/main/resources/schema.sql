drop table if exists health_activity cascade;
drop table if exists health cascade;
CREATE TABLE health (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    recordkey VARCHAR(255) NOT NULL,
    source_mode INTEGER,
    product_name VARCHAR(255),
    product_vendor VARCHAR(255),
    source_name VARCHAR(255),
    source_type VARCHAR(255),
    health_type VARCHAR(255),
    last_update TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE health_activity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    health_id BIGINT NOT NULL,
    steps DECIMAL(30, 17) NOT NULL,
    distance DECIMAL(30, 20) NOT NULL,
    distance_unit VARCHAR(10) NOT NULL,
    calories DECIMAL(20, 8) NOT NULL,
    calories_unit VARCHAR(10) NOT NULL,
    period_from TIMESTAMP NOT NULL,
    period_to TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_period_from (period_from, period_to)
);