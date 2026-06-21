# Quản Lý Công Văn

A document management system (hệ thống quản lý công văn) built with Spring Boot and React.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 3.4.5, Java 26, Gradle 9 |
| Security | Spring Security 6, JWT (jjwt 0.12.5) |
| Database | PostgreSQL 16, Flyway migrations, Spring Data JPA |
| API Docs | SpringDoc OpenAPI / Swagger UI |
| Frontend | React 18, TypeScript, Vite |
| UI | Ant Design 5 |
| State | Zustand, TanStack Query |
| Infra | Docker, Docker Compose |

## Prerequisites

- Java 26+
- Node.js 20+
- Docker Desktop

## Getting Started

### 1. Start the database

```bash
docker compose up -d db
```

### 2. Run the backend

```bash
cd backend
./gradlew bootRun
```

API available at `http://localhost:8080/api`  
Swagger UI at `http://localhost:8080/api/swagger-ui.html`

### 3. Run the frontend

```bash
cd frontend
npm install
npm run dev
```

App available at `http://localhost:5173`

## Build

### Backend JAR

```bash
cd backend
./gradlew bootJar
# output: backend/build/libs/quan-ly-cong-van-1.0.0.jar
```

### Frontend production build

```bash
cd frontend
npm run build
# output: frontend/dist/
```

### Full Docker stack

```bash
docker compose up --build
```

## Testing

```bash
cd backend
./gradlew test
# report: backend/build/reports/tests/test/index.html
```

Tests require the PostgreSQL container to be running (`docker compose up -d db`).

## Project Structure

```
.
├── backend/                  # Spring Boot application
│   ├── src/main/java/com/quangvinh/
│   │   ├── config/           # Security, OpenAPI config
│   │   ├── controller/       # REST controllers
│   │   ├── dto/              # Request / response DTOs
│   │   ├── entity/           # JPA entities
│   │   ├── repository/       # Spring Data repositories
│   │   ├── security/         # JWT filter, UserDetails
│   │   └── service/          # Business logic
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── db/migration/     # Flyway SQL scripts
│   ├── build.gradle.kts
│   └── docker-compose.yml
└── frontend/                 # React + Vite application
    ├── src/
    ├── package.json
    └── vite.config.ts
```

## Environment Variables

The backend reads these at runtime (set via Docker Compose or system env):

| Variable | Default | Description |
|----------|---------|-------------|
| `SPRING_DATASOURCE_URL` | `jdbc:postgresql://localhost:5432/luanvantotnghiep` | PostgreSQL JDBC URL |
| `SPRING_DATASOURCE_USERNAME` | `postgres` | DB username |
| `SPRING_DATASOURCE_PASSWORD` | `postgres` | DB password |
| `APP_JWT_SECRET` | *(see application.yml)* | JWT signing secret (change in production) |
