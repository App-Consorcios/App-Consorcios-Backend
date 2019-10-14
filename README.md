Consorcios API Rest
=========

# Para correr el projecto
```
mvn spring-boot:run
```

Luego http://localhost:8081/usuario

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

## Usuarios

### POST /usuario

```
{
  "nombre": "Jorge",
  "apellido": "Rodriguez",
  "password": "admin123",
  "mail": "rodriguez@admin.com",
  "roles": [
    {
      "nombre": "admin"
    }
  ]
}
```
---

### GET /usuario

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

### GET /login?mail={mail}&password={password}

#### Ejemplos

/login?mail=rodriguez@admin.com&password=admin123

```
{
    "valido": true,
    "usuario": {
        "id": 1,
        "nombre": "Jorge",
        "apellido": "Rodriguez",
        "mail": "rodriguez@admin.com",
        "roles": [
            {
                "nombre": "admin"
            }
        ]
    }
}
```

/login?mail=falso@admin.com&password=admin123

```
{
    "valido": false
}
```

## Conceptos

### POST /conceptos/tipo

Request
```
{
	"nombre": "Generales",
	"color": "Rojo"
}
```
---

### GET /conceptos/tipos

Response 
```
[
    {
        "nombre": "Generales",
        "color": "Rojo"
    },
    {
        "nombre": "Misc",
        "color": "Azul"
    }
]
```
---

### POST /concepto

Request
```
{
	"nombre": "Gasto Administrativo",
	"tipoConcepto": {
		"nombre": "General"
	}
}

```
---

### GET /conceptos

Response 
```
[
    {
        "nombre": "Gasto Administrativo",
        "tipoConcepto": {
            "nombre": "General",
            "color": "Rojo"
        }
    },
    {
        "nombre": "Gasto Mantenimiento",
        "tipoConcepto": {
            "nombre": "General",
            "color": "Rojo"
        }
    }
]
```
---

## Expensas

### POST /expensa

Request
```
{
  "periodo": "2019-10",
  "items": [
    {
      "conceptoNombre": "Gasto Administrativo",
      "monto": "180"
    },
    {
      "conceptoNombre": "Gasto Mantenimiento",
      "monto": "186.4"
    }
  ]
}
```
---

### GET /expensas

QueryParams
* fromPeriodo
* toPeriodo
* periodo

Deben cumplir el formato de `yyyy-MM`

#### Ejemplos

/expensas?periodo=2019-10

```
[
    {
        "periodo": "2019-10",
        "items": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "monto": 180.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "monto": 186.4
            }
        ]
    }
]
```

/expensas?fromPeriodo=2019-09&toPeriodo=2019-12

```
[
    {
        "periodo": "2019-10",
        "items": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "monto": 180.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "monto": 186.4
            }
        ]
    },
    {
        "periodo": "2019-11",
        "items": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "monto": 294.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "monto": 2523.43
            }
        ]
    }
]
```