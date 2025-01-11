# ✅ Todo List Backend API with Spring Boot

Bu proje, **Java Spring Boot** kullanılarak geliştirilmiş bir **Todo List** uygulamasıdır. Kullanıcıların görev ekleme, güncelleme, silme ve tamamlanan/tamamlanmamış görevleri listeleme gibi temel işlemleri gerçekleştirmesine olanak tanır. **Docker** ile containerize edilmiştir ve **PostgreSQL** veritabanı ile çalışmaktadır.

---

## 📦 **Proje Özellikleri:**
- **CRUD İşlemleri:**
    - 🟢 Yeni görev ekleme
    - 🟡 Görev güncelleme
    - 🔴 Görev silme
    - ✅ Tamamlanan/Tamamlanmamış görevleri listeleme
- **Validasyon:**
    - Aynı başlıkla iki görev eklenemez.
    - Güncelleme sırasında aynı başlık kontrolü yapılır.
- **Hata Yönetimi:**
    - Global Exception Handling (RESTful hata yönetimi)
- **Swagger:**
    - API dökümantasyonu için **Swagger UI** entegrasyonu yapılmıştır.

---

## 📦 **Kullanılan Teknolojiler:**
- **Backend:** Java 17, Spring Boot 3.2.0, Spring Data JPA, Lombok
- **Veritabanı:** PostgreSQL
- **Araçlar:** IntelliJ IDEA, Maven, Postman, Docker, Docker Compose
- **Test:** Postman ile manuel testler
- **API Dokümantasyonu:** SpringDoc OpenAPI ve Swagger UI

---

📦 Projeyi Çalıştırma (Docker ile)
bash
Kodu kopyala
# Projeyi Maven ile Build Et
mvn clean package -DskipTests

# Docker Container'larını başlat
docker-compose up --build

# Çalışan containerları listele
docker ps


## 📦 API Endpointleri:
1. Tüm Görevleri Listele
   - Method: GET
   - Endpoint: /api/todos

2. Tamamlanan Görevleri Listele
   - Method: GET
   - Endpoint: /api/todos/done

3. Tamamlanmamış Görevleri Listele
   - Method: GET
   - Endpoint: /api/todos/todo

4. Yeni Görev Ekleme
   - Method: POST
   - Endpoint: /api/todos
   - Body:
     {
       "title": "Yeni Görev"
     }

5. Görev Güncelleme
   - Method: PUT
   - Endpoint: /api/todos/{id}
   - Body:
     {
       "title": "Güncellenmiş Görev",
       "completed": true
     }

6. Bir Görevi Sil
   - Method: DELETE
   - Endpoint: /api/todos/{id}

7. Tamamlanan Görevleri Sil
   - Method: DELETE
   - Endpoint: /api/todos/delete-completed

8. Tüm Görevleri Sil
   - Method: DELETE
   - Endpoint: /api/todos/delete-all


## 📦 Proje Görselleri:
- **Postman Test Ekran Görüntüleri:**
    - Başarıyla ekleme:  
      ![PostSuccess](PostmanScreen/PostSuccess.png)
    - Başarısız ekleme:  
      ![PostFalse](PostmanScreen/PostFalse.png)
    - Güncelleme başarı:  
      ![PutSucces](PostmanScreen/PutSucces.png)
    - Tüm görevleri listeleme:  
      ![GetAll](PostmanScreen/GetAll.png)
    - Tamamlanmamış görevleri listeleme:  
      ![GetTodoAll](PostmanScreen/GetTodoAll.png)
    - Tamamlanan görevleri listeleme:  
      ![GetDoneAll](PostmanScreen/GetDoneAll.png)
    - Başarıyla görev silme:  
      ![DeleteTodoSuccess](PostmanScreen/DeleteTodoSuccess.png)
    - Başarısız görev silme:  
      ![DeleteTodoFalse](PostmanScreen/DeleteTodoFalse.png)
    - Tamamlanan görevleri silme:  
      ![DeleteDoneAll](PostmanScreen/DeleteDoneAll.png)
    - Tüm görevleri silme:  
      ![DeleteAll](PostmanScreen/DeleteAll.png)

## 📦 Swagger UI Görselleri:
- **Swagger Endpoint Görseli:**  
  ![Swagger Endpointler](SwaggerScreen/swaggerEndpointler.png)

- **Başarıyla Ekleme:**  
  ![Post Success](SwaggerScreen/postSuccess.png)

- **Başarısız Ekleme:**  
  ![Post False](SwaggerScreen/postFalse.png)

- **Başarıyla Güncelleme:**  
  ![Put Success](SwaggerScreen/putSuccess.png)

- **Başarısız Güncelleme:**  
  ![Put False](SwaggerScreen/putFalse.png)

- **Tüm Görevleri Listeleme:**  
  ![Get All](SwaggerScreen/getAll.png)

- **Tamamlanmamış Görevleri Listeleme:**  
  ![Get Todo](SwaggerScreen/getTodo.png)

- **Tamamlanan Görevleri Listeleme:**  
  ![Get Done](SwaggerScreen/getDone.png)

- **Başarıyla Görev Silme:**  
  ![Delete Todo Success](SwaggerScreen/DeleteTodoSucces.png)

- **Başarısız Görev Silme:**  
  ![Delete Todo False](SwaggerScreen/DeleteTodoFalse.png)

- **Tamamlanan Görevleri Silme:**  
  ![Delete Done Success](SwaggerScreen/DeleteDoneSucces.png)

- **Tüm Görevleri Silme:**  
  ![Delete All](SwaggerScreen/DeleteAll.png)


📦 Proje Geliştiricisi:
- İsim: Yakup Eren Ermurat
- GitHub: https://github.com/yakuperenermurat
- LinkedIn: https://www.linkedin.com/in/yakuperenermurat/
- E-Posta: yakuperenermurat@gmail.com

## 📦 **Proje Yapısı:**
```plaintext
src
├── main
│   └── java
│       └── com
│           └── yakuperenermurat
│               └── todolist
│                   ├── controller
│                   ├── dto
│                   ├── entity
│                   ├── exception
│                   ├── repository
│                   ├── response
│                   ├── service
│                   │   └── impl
│                   └── TodoListBackendApplication.java
│
├── resources
│   └── application.yml
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
