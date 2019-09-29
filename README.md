Consorcios API Rest
=========

# Para correr el projecto
```
mvn spring-boot:run
```

Luego http://localhost:8081/user

Si desean cambiar el puerto, pueden editar el application.properties

# Heroku

La API se encuentra hosteada en

https://app-consorcios-backend.herokuapp.com/

### Comandos Utiles

Pushear cambios y subir a produccion
```
git push heroku master
```

Logs
```
heroku logs --tail -a app-consorcios-backend
```