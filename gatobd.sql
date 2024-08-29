-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS gatos_db;
USE gatos_db;

-- Crear la tabla de razas de gatos
CREATE TABLE IF NOT EXISTS razas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    origen VARCHAR(100)
);

-- Crear la tabla de dueños
CREATE TABLE IF NOT EXISTS duenos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20)
);

-- Crear la tabla de gatos
CREATE TABLE IF NOT EXISTS gatos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    raza_id INT,
    dueno_id INT,
    FOREIGN KEY (raza_id) REFERENCES razas(id),
    FOREIGN KEY (dueno_id) REFERENCES duenos(id)
);

-- Crear la tabla de visitas al veterinario
CREATE TABLE IF NOT EXISTS visitas_veterinario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    gato_id INT,
    fecha_visita DATE NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    FOREIGN KEY (gato_id) REFERENCES gatos(id)
);

-- Insertar datos en la tabla de razas
INSERT INTO razas (nombre, origen) VALUES 
('Siamés', 'Tailandia'),
('Persa', 'Irán'),
('Maine Coon', 'Estados Unidos');

-- Insertar datos en la tabla de dueños
INSERT INTO duenos (nombre, direccion, telefono) VALUES 
('Juan Perez', 'Calle Falsa 123', '555-1234'),
('Ana Gomez', 'Av. Siempre Viva 742', '555-5678');

-- Insertar datos en la tabla de gatos
INSERT INTO gatos (nombre, fecha_nacimiento, raza_id, dueno_id) VALUES 
('Michi', '2020-03-15', 1, 1),
('Pelusa', '2019-08-30', 2, 2),
('Garfield', '2018-11-05', 3, 1);

-- Insertar datos en la tabla de visitas al veterinario
INSERT INTO visitas_veterinario (gato_id, fecha_visita, motivo) VALUES 
(1, '2023-01-20', 'Vacunación'),
(2, '2023-02-15', 'Chequeo general'),
(3, '2023-03-10', 'Corte de uñas');
