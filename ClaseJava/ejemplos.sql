INSERT INTO gestor (usuario, password, correo) VALUES ('gestor4', 'passworddegestor4', 'gestor4@mail.com');

SELECT id, usuario 
	FROM gestor
    WHERE id>1
    ORDER BY correo

SELECT *
	FROM gestor
    WHERE id>1

SELECT id, usuario
    FROM gestor 
    WHERE usuario = 'gestor1'

SELECT id, usuario 
    FROM gestor 
    WHERE usuario
    LIKE 'g%'

SELECT id, usuario 
    FROM gestor 
    WHERE id 
    BETWEEN 1 AND 2

SELECT id, usuario 
    FROM gestor
    WHERE usuario IN ('gestor1', 'gestor2', 'gestor3');

SELECT id, usuario 
    FROM gestor
    WHERE id > 1 AND id <= 3;

SELECT id, usuario 
    FROM gestor
    WHERE id = 1 OR id = 3;

-- número de registros de la tabla gestor
SELECT COUNT(*)	FROM gestor;    

-- actualiza los campos correo (al valor gestor3@gmail.com) y id (al valor 8)
-- para los gestores que cumpla la condicion de id igual a 3 y usuario igual a gestor3
UPDATE gestor 
	SET correo = 'gestor3@gmail.com', id=8
	WHERE id=3 AND usuario='gestor3'

DELETE FROM gestor 
    WHERE id=82