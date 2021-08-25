CREATE DATABASE hardware_store_manager;
-- CREATE  USER 'hardware_store_manager_user'@'localhost' IDENTIFIED BY  'root';
-- GRANT ALL ON hardware_store_manager.* TO  'hardware_store_manager_user'@'localhost';
-- ALTER USER 'hardware_store_manager_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
use hardware_store_manager;

CREATE TABLE users(
    username varchar(80) PRIMARY KEY,
    password varchar(240) NOT NULL
);

CREATE TABLE employers(
    id int PRIMARY KEY AUTO_INCREMENT,
    last_name varchar(80) NOT NULL,
    first_name varchar(150) NOT NULL,
    birth_date date,
    sex ENUM('M', 'F'),
    role varchar(80),
    UNIQUE(last_name, first_name)
);

CREATE TABLE products(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    designation varchar(80) UNIQUE NOT NULL,
    description varchar(80),
    price DOUBLE NOT NULL
);

CREATE TABLE stock(
    id_product int NOT NULL,
    date_entry_product datetime NOT NULL,
    quantity int NOT NULL,

    PRIMARY KEY(id_product, date_entry_product),
    FOREIGN KEY(id_product) REFERENCES products(id)
);

CREATE TABLE clients(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    num_CIN varchar(25) NOT NULL UNIQUE,
    last_name varchar(80) NOT NULL,
    first_name varchar(150) NOT NULL,
    category ENUM('detaillant', 'grossiste') NOT NULL,
    tel varchar(15),
    UNIQUE(last_name, first_name)
);

CREATE TABLE orders(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_client int NOT NULL,
    id_employer int NOT NULL,
    date_order datetime NOT NULL,
    
    FOREIGN KEY(id_client) REFERENCES clients(id),
    FOREIGN KEY(id_employer) REFERENCES employers(id)
);

CREATE TABLE orders_details(
    id_order int NOT NULL,
    id_product int NOT NULL,
    date_entry_product datetime NOT NULL,
    quantity int NOT NULL,

    FOREIGN KEY(id_product) REFERENCES products(id),
    FOREIGN KEY(id_order) REFERENCES orders(id),
    PRIMARY KEY(id_order, id_product, date_entry_product)
);

CREATE TABLE bills(
    id_order int NOT NULL,
    date_bill datetime,

    FOREIGN KEY(id_order) REFERENCES orders(id)
);
INSERT INTO `clients` (`id`, `num_CIN`, `last_name`, `first_name`, `category`, `tel`) VALUES
(1, 'QSDF45D', 'Albert', 'clément', 'grossiste', '+228 91611135');
INSERT INTO `employers` (`id`, `last_name`, `first_name`, `birth_date`, `sex`, `role`) VALUES
(1, 'KOUDOSSOU', 'Justin', '2000-05-02', 'F', 'PDG'),
(2, 'GAMLIGO', 'Charles Dieu-Donné', '2000-03-03', 'F', 'Directeur');
INSERT INTO `products` (`id`, `designation`, `description`, `price`) VALUES
(1, 'rice: Gino', 'The best rice of the market', 4500);
INSERT INTO `stock` (`id_product`, `date_entry_product`, `quantity`) VALUES
(1, '2021-08-25 14:14:03', 2);
INSERT INTO `users` (`username`, `password`) VALUES
('root', 'root');
INSERT INTO `orders` (`id`, `id_client`, `id_employer`, `date_order`) VALUES (0, 1, 1, NOW());