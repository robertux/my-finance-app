-- Sample data for Cuenta table
INSERT INTO Cuenta (numero, estado, saldo, usuarioId) VALUES
(123456, 'A', 1000.00, 1),
(654321, 'A', 500.00, 2);

-- Sample data for Usuario table
INSERT INTO Usuario (nombre, correo, password, estado) VALUES
('John Doe', 'john@example.com', 'password123', 'A'),
('Jane Smith', 'jane@example.com', 'password456', 'A');

-- Sample data for Transaccion table
INSERT INTO Transaccion (cuentaId, monto, tipo, estado, descripcion, confirmacion, etiqueta) VALUES
(1, 200.00, 'D', 'A', 'Deposit', 1, 'Salary'),
(1, 50.00, 'R', 'A', 'Withdrawal', 1, 'Groceries'),
(2, 100.00, 'D', 'A', 'Deposit', 1, 'Gift');