# Java library to serialize and deserialize Java objects to (and from) JSON

[![Build Status](https://travis-ci.org/fedorchuck/dnjson.svg?branch=master)](https://travis-ci.org/fedorchuck/dnjson)
[![Apache License Version 2.0](https://img.shields.io/badge/license-Apache%20License%202.0-brightgreen.svg)](https://github.com/fedorchuck/dnjson/blob/master/LICENSE.md)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/dnjson/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/dnjson)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4a58d74a6b6443c28a62656de1587f49)](https://www.codacy.com/app/vl.fedorchuck/dnjson?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fedorchuck/dnjson&amp;utm_campaign=Badge_Grade)

## Introduction
DNJson uses reflection so it does not require additional modifications to classes of (de)serialized objects. In fact it just needs the class to have defined default no-args constructor (not entirely true, see Features).

This library compatible with Java 6+

## Contents

- [Getting started](#getting-started)
  - [Download](#download)
- [Usage](#usage)
- [Changelog](#changelog)
- [License](#license)

## Getting started
### Download
Gradle:
```groovy
compile 'com.github.fedorchuck:dnjson:0.1.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.fedorchuck</groupId>
  <artifactId>dnjson</artifactId>
  <version>0.1.0</version>
</dependency>
```
JAR-files:  
https://oss.sonatype.org/content/repositories/releases/com/github/fedorchuck/dnjson/

### Usage
The following example demonstrates the most basic usage of DNJson when serializing a sample object:

```groovy    
    public class Car {
        private String manufacturer;
        private String model;
        private Double capacity;
        private boolean accident;
    
        private Car() {
        }
    
        public Car(String manufacturer, String model, Double capacity, boolean accident) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.capacity = capacity;
            this.accident = accident;
        }
    
        @Override
        public String toString() {
            return("Manufacturer: " + manufacturer + ", " + "Model: " + model + ",
                    " + "Capacity: " + capacity + ", " + "Accident: " + accident);
        }
    }
    
    public class Person {
        private String name;
        private String surname;
        private Car[] cars;
        private int phone;
        private transient int age;
    
        private Person() {
        }
    
        public Person(String name, String surname, int phone, int age, Car[] cars) {
            this.name = name;
            this.surname = surname;
            this.cars = cars;
            this.phone = phone;
            this.age = age;
        }
    
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
    
            sb.append("Name: " + name + " " + surname + "\n");
            sb.append("Phone: " + phone + "\n");
            sb.append("Age: " + age + "\n");
    
            int i = 0;
            for (Car item : cars) {
                i++;
                sb.append("Car " + i + ": " + item + "\n");
            }
    
            return sb.toString();
        }
    }
```
After calling    
```groovy    
    DNJson dnjson = new DNJson();
    Car audi = new Car("Audi", "A4", 1.8, false);
    Car skoda = new Car("Škoda", "Octavia", 2.0, true);
    Car[] cars = {audi, skoda};
    Person johnDoe = new Person("John", "Doe", 245987453, 35, cars);
    System.out.println(dnjson.toJson(johnDoe));
```    
you will get this output:
```json    
    {
        "name": "John",
        "surname": "Doe",
        "cars": [
            {
                "manufacturer": "Audi",
                "model": "A4",
                "capacity": 1.8,
                "accident": false
            },
            {
                "manufacturer": "Škoda",
                "model": "Octavia",
                "capacity": 2,
                "accident": true
            }
        ],
        "phone": 245987453
    }
```    
Since the Person's field `age` is marked as transient, it is not included in the output.
    
To deserialize output produced by last example, you can execute the following code:
```groovy    
    DNJson dnjson = new DNJson();
    String json =
    "{\"name\":\"John\",\"surname\":\"Doe\",\"cars\":
    [{\"manufacturer\":\"Audi\",\"model\":\"A4\",\"capacity\":1.8,\"accident\":false},
    {\"manufacturer\":\"Škoda\",\"model\":\"Octavia\",\"capacity\":2.0,\"accident\":true}],
    \"phone\":245987453}";
    Person johnDoe = dnjson.fromJson(json, Person.class);
    System.out.println(johnDoe.toString());
```    
And the following output will be generated:
```    
    Name: John Doe
    Phone: 245987453
    Age: 0
    Car 1: Manufacturer: Audi, Model: A4, Capacity: 1.8, Accident: false
    Car 2: Manufacturer: Škoda, Model: Octavia, Capacity: 2.0, Accident: true
```    

## Changelog
See [changelog file](https://github.com/fedorchuck/dnjson/blob/master/CHANGELOG.md)

## License
This software is licensed under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
