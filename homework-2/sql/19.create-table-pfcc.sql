--  белки жиры углев
create table pfcc
(
    id            SERIAL PRIMARY KEY,
    proteins      NUMERIC,
    fats          NUMERIC,
    calories      NUMERIC,
    carbohydrates NUMERIC
);