CREATE TABLE `product` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `product_name` VARCHAR(100) DEFAULT NULL COMMENT '商品名称',
                           `price` DOUBLE(15, 3) DEFAULT NULL COMMENT '商品价格',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;