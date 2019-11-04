Consorcios API Rest
=========

# Para correr el projecto
```
mvn spring-boot:run
```

Luego acceder por http://localhost:8081/

Si desean cambiar el puerto, pueden editar el application.properties

# Postman

https://www.getpostman.com/collections/bc53ce0b99d572c2a3c4

# Heroku

La API se encuentra hosteada en

https://app-consorcios-backend.herokuapp.com/

### Comandos Utiles

Subir a Produccion
```
git push heroku master
```

Logs
```
heroku logs --tail -a app-consorcios-backend
```

# API

## Roles

### POST /rol

Request
```
{
  "nombre": "admin"
}
```
---

### GET /roles

Response
```
[
    {
        "nombre": "admin"
    },
    {
        "nombre": "alquilino"
    }
]
```

---

## Usuarios

### POST /usuario

Request
```
{
  "nombre": "Jorge",
  "apellido": "Rodriguez",
  "password": "admin123",
  "mail": "rodriguez@admin.com",
  "imagen": "urlToImg",
  "roles": [
    {
      "nombre": "admin"
    }
  ]
}
```
---

### GET /usuarios

Response
```
[
    {
        "id": 1,
        "nombre": "Jorge",
        "apellido": "Rodriguez",
        "mail": "rodriguez@admin.com",
        "imagen": "urlToImg",
        "roles": [
            {
                "nombre": "admin"
            }
        ]
    }
]
```

---

### PUT /usuario?id={userId}

Solo se puede modificar la lista de Roles para el Usuario dado.
Tener en cuenta que la nueva lista, reemplazara la existente.

Request
```
{
  "roles": [
    {
      "nombre": "admin"
    },
    {
      "nombre": "usuario"
    }
  ]
}
```

Response
```
{
    "id": 2,
    "nombre": "Jorge",
    "apellido": "Rodriguez",
    "mail": "otroAdmin@admin.com",
    "imagen": "urlToImg",
    "roles": [
        {
            "nombre": "admin"
        },
        {
            "nombre": "usuario"
        }
    ]
}
```

---

### GET /login?mail={mail}&password={password}

#### Ejemplos

Usuario Valido:

/login?mail=rodriguez@admin.com&password=admin123

Response
```
{
    "valido": true,
    "usuario": {
        "id": 1,
        "nombre": "Jorge",
        "apellido": "Rodriguez",
        "mail": "rodriguez@admin.com",
        "imagen": "urlToImg",
        "roles": [
            {
                "nombre": "admin"
            }
        ]
    }
}
```

Usuario Invalido:

/login?mail=falso@admin.com&password=admin123

Response
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

### DELETE /concepto?nombre=Gasto+Asd

Delete Concepto by Name. Replace whitespaces with "+".
In this example the Concept name was "Gasto Asd"

Response
```
true
```
---

## Expensas

### POST /expensa

Request
```
{
  "periodo": "2019-10",
  "itemsGenerales": [
    {
      "conceptoNombre": "Gasto Administrativo",
      "descripcion": "Descricion de Gasto Administrativo",
      "monto": "180"
    },
    {
      "conceptoNombre": "Gasto Mantenimiento",
      "descripcion": "Descricion de Gasto Mantenimiento",
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

Response
```
[
    {
        "periodo": "2019-10",
        "itemsGenerales": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "descripcion": "Descricion de Gasto Administrativo",
                "monto": 180.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "descripcion": "Descricion de Gasto Mantenimiento",
                "monto": 186.4
            }
        ]
    }
]
```

/expensas?fromPeriodo=2019-09&toPeriodo=2019-12

Response
```
[
    {
        "periodo": "2019-10",
        "itemsGenerales": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "descripcion": "Descricion de Gasto Administrativo",
                "monto": 180.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "descripcion": "Descricion de Gasto Mantenimiento",
                "monto": 186.4
            }
        ]
    },
    {
        "periodo": "2019-11",
        "itemsGenerales": [
            {
                "conceptoNombre": "Gasto Administrativo",
                "descripcion": "Descricion de Gasto Administrativo",
                "monto": 294.0
            },
            {
                "conceptoNombre": "Gasto Mantenimiento",
                "descripcion": "Descricion de Gasto Mantenimiento",
                "monto": 2523.43
            }
        ]
    }
]
```

---

## Unidad Funcional

### POST /unidad-funcional

Request
```
{
    "codigoDepartamento": "1-C",
    "descripcionDepartamento": "Descripcion del 1C",
    "metrosCuadrados": 32,
    "prorrateo": "0.4",
    "codigoUbicacion": "CF",
    "descripcionUbicacion": "Algo sobre CF"
}
```
---

### PUT /unidad-funcional?id=1

Request
```
{
	"propietario" : {
		"mail": "pedro@propietario.com"
	}
}
```

Request
```
{
	"inquilino" : {
		"mail": "maria@inquilina.com"
	}
}
```
---

### GET /unidades-funcionales

#### Examples

Response
```
[
    {
        "id": 1,
        "codigoDepartamento": "1-C",
        "descripcionDepartamento": "Descripcion del 1C",
        "metrosCuadrados": 32,
        "prorrateo": 0.4,
        "codigoUbicacion": "CF",
        "descripcionUbicacion": "Algo sobre CF"
    }
]
```

Response with Users
```
[
    {
        "id": 1,
        "codigoDepartamento": "1-C",
        "descripcionDepartamento": "Descripcion del 1C",
        "metrosCuadrados": 32,
        "prorrateo": 0.4,
        "codigoUbicacion": "CF",
        "descripcionUbicacion": "Algo sobre CF",
        "propietario": {
            "id": 1,
            "nombre": "Pedro",
            "apellido": "Rodriguez",
            "mail": "pedro@propietario.com",
            "imagen": "urlToImg",
            "roles": [
                {
                    "nombre": "propietario"
                }
            ]
        },
        "inquilino": {
            "id": 2,
            "nombre": "Maria",
            "apellido": "Rodriguez",
            "mail": "maria@inquilina.com",
            "imagen": "urlToImg",
            "roles": [
                {
                    "nombre": "inquilino"
                }
            ]
        }
    }
]
```