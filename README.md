Consorcios API Rest
=========

# Para correr el projecto
```
mvn spring-boot:run
```

Luego http://localhost:8081/appUser

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

# API

## Users

GET /user

Lista todos los usuarios

```
[
    {
        "id": 1,
        "name": "Jorge",
        "lastname": "Rodriguez",
        "mail": "rodriguez@admin.com",
        "phone": "12345678"
    }
]
```

---

GET /login?mail={mail}&password={password}

Devuelve un boolean indicando si el mail, corresponde con la contraseña.

## Expensas

POST /expense

Request
```
{
  "periodo": "2019-11",
  "cargasSociales": "24.4",
  "abonosServicios": "213.4",
  "reparaciionesEdificio": "345.45",
  "serviciosPublicos": "234.442",
  "gastosAdministrativos": "56.4",
  "gastosMantenimiento": "73.86"
}
```

Response 
```
{
    "id": 2,
    "periodo": "2019-11",
    "cargasSociales": 24.4,
    "abonosServicios": 213.4,
    "reparacionesEdificio": 0.0,
    "serviciosPublicos": 234.442,
    "gastosAdministrativos": 56.4,
    "gastosMantenimiento": 73.86
}
```
---

GET /expense

QueryParams
* fromPeriod
* toPeriod
* period

Deben cumplir el formato de `yyyy-MM`

#### Ejemplos

/expense?period=2019-10

```
[
    {
        "id": 1,
        "periodo": "2019-10",
        "cargasSociales": 24.4,
        "abonosServicios": 552.4,
        "reparacionesEdificio": 0.0,
        "serviciosPublicos": 245.442,
        "gastosAdministrativos": 6134.4,
        "gastosMantenimiento": 73.86
    }
]
```

/expense?fromPeriod=2019-09&toPeriod=2019-12

```
[
    {
        "id": 1,
        "periodo": "2019-10",
        "cargasSociales": 24.4,
        "abonosServicios": 552.4,
        "reparacionesEdificio": 0.0,
        "serviciosPublicos": 245.442,
        "gastosAdministrativos": 6134.4,
        "gastosMantenimiento": 73.86
    },
    {
        "id": 2,
        "periodo": "2019-11",
        "cargasSociales": 24.4,
        "abonosServicios": 213.4,
        "reparacionesEdificio": 0.0,
        "serviciosPublicos": 234.442,
        "gastosAdministrativos": 56.4,
        "gastosMantenimiento": 73.86
    }
]
```