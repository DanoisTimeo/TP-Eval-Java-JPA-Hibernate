Timéo Danois, B3 DEV Epsi Nantes. Ce projet réalise le TP : Java – TP Eval – ORM – JPA – Hibernate

## Lancement de la BDD
### Docker
Lancement du conteneur
```console
docker-compose up --build -d
```

Trouver l'id du conteneur
```console
docker ps
```

Ouvrir le conteneur pour ecrire les scripts PostgreSQL
```console
docker exec -it <ID_CONTENEUR> psql -U petstore -d petstore
```

### Script PostgreSQL pour voir les tables + colonnes regroupées
```
SELECT
    c.table_schema,
    c.table_name,
    string_agg(
        c.column_name || ' (' || c.data_type || ')',
        ', ' ORDER BY c.ordinal_position
    ) AS columns
FROM information_schema.columns c
WHERE c.table_schema NOT IN ('pg_catalog', 'information_schema')
GROUP BY c.table_schema, c.table_name
ORDER BY c.table_schema, c.table_name;
```
