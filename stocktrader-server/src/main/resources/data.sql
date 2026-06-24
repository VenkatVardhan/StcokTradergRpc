-- 1. Create and use the database
CREATE DATABASE IF NOT EXISTS stock_trader;
USE stock_trader;

-- 2. Create the stocks table
CREATE TABLE IF NOT EXISTS stocks (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      stock_symbol VARCHAR(255) NOT NULL UNIQUE,
    price DOUBLE NOT NULL,
    last_updated DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    currency VARCHAR(255)
    );

-- 3. Insert mock stock data
INSERT INTO stocks (stock_symbol, price, last_updated, currency) VALUES
                                                                     ('AAPL', 185.50, NOW(6), 'USD'),
                                                                     ('MSFT', 420.75, NOW(6), 'USD'),
                                                                     ('GOOGL', 175.20, NOW(6), 'USD'),
                                                                     ('AMZN', 180.10, NOW(6), 'USD'),
                                                                     ('TSLA', 170.45, NOW(6), 'USD');