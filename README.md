Consorcios API Rest
=========

# Para correr el projecto
```
mvn spring-boot:run
```

Luego acceder por http://localhost:8081/

Si desean cambiar el puerto, pueden editar el application.properties

# Postman

https://www.getpostman.com/collections/cb0ce0b86b4c1d81a77b

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

### GET /expensas-unidades-funcionales/calcular

Calcula las expensas de todas las unidades funcionales para el Mes en curso.
El calculo consiste en multiplicar el factor de prorrateo por cada valor de concepto de la expensa general.

En el ejemplo:
* PB-01 tiene 0,07 de prorrateo
* PB-02 tiene 0.1 de prorrateo
* El total de "Gasto Administrativo" es de 14000
* El total de "Gasto Mantenimiento" es de 600

Response
```
{
    "periodo": "2019-11",
    "expensasUnidadesFuncionales": [
        {
            "codigoDepartamento": "PB-01",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 980.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 42.0
                }
            ]
        },
        {
            "codigoDepartamento": "PB-02",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 1400.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 60.0
                }
            ]
        }
    ]
}
```
---

### POST /expensas-unidades-funcionales

No es necesario enviar body. El backend vuelve a realizar el calculo del Mes en curso, y persiste el resultado.

Response
```
{
    "periodo": "2019-11",
    "expensasUnidadesFuncionales": [
        {
            "codigoDepartamento": "PB-01",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 980.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 42.0
                }
            ]
        },
        {
            "codigoDepartamento": "PB-02",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 1400.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 60.0
                }
            ]
        }
    ]
}
```
---

### GET /expensas-unidades-funcionales?periodo=2019-11

Response
```
{
    "periodo": "2019-11",
    "expensasUnidadesFuncionales": [
        {
            "codigoDepartamento": "PB-01",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 980.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 42.0
                }
            ]
        },
        {
            "codigoDepartamento": "PB-02",
            "items": [
                {
                    "conceptoNombre": "Gasto Administrativo",
                    "monto": 1400.0
                },
                {
                    "conceptoNombre": "Gasto Mantenimiento",
                    "monto": 60.0
                }
            ]
        }
    ]
}
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

Servicio para actualizar el propietario y/o inquilino de la unidad funcional dada. 
Tener en cuenta que si uno de los valores no se envia, se elimina cualquier asociacion existente respecto a dicho valor. 

Ejemplos

Aqui se asocia tanto el propietario como el inquilino

Request
```
{
    "propietario" : {
        "mail": "pedro@propietario.com"
    },
    "inquilino" : {
        "mail": "maria@inquilina.com"
    }
}
```

Pero aqui solo se asocia el inquilino. Entonces si existia alguna asociacion de propietario, se pierde.
En caso de querer manternerla, se debe enviar en el request la asociacion existente.

Request
```
{
	"inquilino" : {
		"mail": "otraPersona@inquilina.com"
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

---

## Reuniones

### POST /reunion

Request
```
{
  "color": "rojo",
  "descripcion": "desc",
  "fecha": "2016-11-15T20:54:40.110Z",
  "temas": [
    {
      "descripcion": "Agua"
    },
    {
      "descripcion": "Fuego"
    }
  ]
}
```
---

### PUT /reunion?id=1

Only updates the date.

Request
```
{
  "fecha": "2016-11-15T18:54:40.110Z"
}
```

Response
```
{
    "id": 1,
    "color": "rojo",
    "descripcion": "desc",
    "fecha": "2016-11-15T18:54:40.110+0000",
    "temas": [
        {
            "id": 1,
            "descripcion": "Agua"
        },
        {
            "id": 2,
            "descripcion": "Fuego"
        }
    ]
}
```
---

### DELETE /reunion?id=1

Response
```
true
```
---

### GET /reuniones

Response
```
[
    {
        "id": 1,
        "color": "rojo",
        "descripcion": "desc",
        "fecha": "2016-11-15T18:54:40.110+0000",
        "temas": [
            {
                "id": 1,
                "descripcion": "Agua"
            },
            {
                "id": 2,
                "descripcion": "Fuego"
            }
        ]
    }
]
```