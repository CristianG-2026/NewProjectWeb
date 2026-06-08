-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: newproject
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `idcarrito` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`idcarrito`),
  KEY `FKs7t94gt1b96owjf3itwku97lk` (`cliente_id`),
  CONSTRAINT `FKs7t94gt1b96owjf3itwku97lk` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;

--
-- Table structure for table `carrito_detalle`
--

DROP TABLE IF EXISTS `carrito_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito_detalle` (
  `idcarrito_detalle` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `carrito_id` bigint NOT NULL,
  `producto_variante_id` bigint NOT NULL,
  PRIMARY KEY (`idcarrito_detalle`),
  KEY `FK64qh3ohthoj94ehwxqfqfgrvu` (`carrito_id`),
  KEY `FK1bs60m1tlwdshkx63bns2iqk3` (`producto_variante_id`),
  CONSTRAINT `FK1bs60m1tlwdshkx63bns2iqk3` FOREIGN KEY (`producto_variante_id`) REFERENCES `producto_variante` (`idvariante`),
  CONSTRAINT `FK64qh3ohthoj94ehwxqfqfgrvu` FOREIGN KEY (`carrito_id`) REFERENCES `carrito` (`idcarrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_detalle`
--

/*!40000 ALTER TABLE `carrito_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito_detalle` ENABLE KEYS */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `codcategoria` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `estado` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`codcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'2026-05-31 00:33:45.000000',1,'Ropa de Hombre','2026-05-31 00:33:45.000000'),(2,'2026-05-31 00:33:46.000000',1,'Ropa de Mujer','2026-05-31 00:33:46.000000'),(3,'2026-05-31 00:33:47.000000',1,'Ropa Deportiva','2026-05-31 00:33:47.000000'),(4,'2026-05-31 00:33:47.000000',1,'Accesorios','2026-05-31 00:33:47.000000'),(5,'2026-05-31 00:33:48.000000',1,'Calzado','2026-05-31 00:33:48.000000'),(6,'2026-05-31 00:33:50.000000',1,'Ropa Infantil','2026-05-31 00:33:50.000000'),(7,'2026-05-31 00:33:51.000000',1,'Jeans y Pantalones','2026-05-31 00:33:51.000000'),(8,'2026-05-31 00:33:52.000000',1,'Camisas y Blusas','2026-05-31 00:33:52.000000'),(9,'2026-05-31 00:33:52.000000',1,'Chaquetas y Abrigos','2026-05-31 00:33:52.000000'),(10,'2026-05-31 00:33:54.000000',1,'Vestidos y Faldas','2026-05-31 00:33:54.000000');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `updatedat` datetime(6) NOT NULL,
  `idusuario` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjh254obpcmi3ylghnyu7h4d5q` (`idusuario`),
  CONSTRAINT `FKjh254obpcmi3ylghnyu7h4d5q` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento` (
  `iddescuento` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `descripcion` text,
  `estado` int NOT NULL,
  `fecha_fin` datetime(6) NOT NULL,
  `fecha_inicio` datetime(6) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `porcentaje` decimal(5,2) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`iddescuento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (1,'2026-05-31 00:35:38.000000','Descuento por liquidacion de temporada verano',1,'2026-03-31 23:59:59.000000','2026-01-01 00:00:00.000000','Liquidacion Verano',30.00,'2026-05-31 00:35:38.000000'),(2,'2026-05-31 00:35:39.000000','Descuento especial Cyber Monday',1,'2026-06-01 23:59:59.000000','2026-05-25 00:00:00.000000','Cyber Monday',50.00,'2026-05-31 00:35:39.000000'),(3,'2026-05-31 00:35:40.000000','10% de descuento en primera compra',1,'2026-12-31 23:59:59.000000','2026-01-01 00:00:00.000000','Descuento Nuevos Clientes',10.00,'2026-05-31 00:35:40.000000'),(4,'2026-05-31 00:35:41.000000','Descuento flash por tiempo limitado',1,'2026-06-07 23:59:59.000000','2026-06-01 00:00:00.000000','Oferta Relampago',40.00,'2026-05-31 00:35:41.000000');
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;

--
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envio` (
  `idenvio` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `estado` int NOT NULL,
  `fecha_envio` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) NOT NULL,
  `venta_id` bigint NOT NULL,
  PRIMARY KEY (`idenvio`),
  KEY `FK7j1ndo13pdxr1vle7hqe03st9` (`venta_id`),
  CONSTRAINT `FK7j1ndo13pdxr1vle7hqe03st9` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envio`
--

/*!40000 ALTER TABLE `envio` DISABLE KEYS */;
/*!40000 ALTER TABLE `envio` ENABLE KEYS */;

--
-- Table structure for table `metodo_pago`
--

DROP TABLE IF EXISTS `metodo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodo_pago` (
  `idmetodo_pago` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `estado` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`idmetodo_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo_pago`
--

/*!40000 ALTER TABLE `metodo_pago` DISABLE KEYS */;
INSERT INTO `metodo_pago` VALUES (1,'2026-05-31 00:33:41.000000',1,'Efectivo','2026-05-31 00:33:41.000000'),(2,'2026-05-31 00:33:41.000000',1,'Tarjeta Credito/Debito','2026-05-31 00:33:41.000000'),(3,'2026-05-31 00:33:42.000000',1,'Yape','2026-05-31 00:33:42.000000'),(4,'2026-05-31 00:33:43.000000',1,'Plin','2026-05-31 00:33:43.000000'),(5,'2026-05-31 00:33:43.000000',1,'Transferencia Bancaria','2026-05-31 00:33:43.000000'),(6,'2026-05-31 00:33:44.000000',1,'Contraentrega','2026-05-31 00:33:44.000000');
/*!40000 ALTER TABLE `metodo_pago` ENABLE KEYS */;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion` (
  `idnotificacion` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `leido` int DEFAULT NULL,
  `mensaje` text NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`idnotificacion`),
  KEY `FK6joahdy7nh295ddmy4qtarl2q` (`cliente_id`),
  CONSTRAINT `FK6joahdy7nh295ddmy4qtarl2q` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idpago` bigint NOT NULL AUTO_INCREMENT,
  `estado` int NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `transaccion_externa` varchar(255) DEFAULT NULL,
  `metodo_pago_id` bigint NOT NULL,
  `venta_id` bigint NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `FKnpwrxs1hm58nsa54qya8peb5a` (`metodo_pago_id`),
  KEY `FKf8e64qamf9mtw4e6rpg0f4te3` (`venta_id`),
  CONSTRAINT `FKf8e64qamf9mtw4e6rpg0f4te3` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`idventa`),
  CONSTRAINT `FKnpwrxs1hm58nsa54qya8peb5a` FOREIGN KEY (`metodo_pago_id`) REFERENCES `metodo_pago` (`idmetodo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idpedido` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `estado` int NOT NULL,
  `fechaentrega` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) NOT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`),
  CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;

--
-- Table structure for table `pedido_detalle`
--

DROP TABLE IF EXISTS `pedido_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_detalle` (
  `idpedido_detalle` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `pedido_id` bigint NOT NULL,
  `producto_variante_id` bigint NOT NULL,
  PRIMARY KEY (`idpedido_detalle`),
  KEY `FKhuvcqbd92kc4eqypgqmyi17cb` (`pedido_id`),
  KEY `FKpa32yt3hf8rtkx3xeemipfjjb` (`producto_variante_id`),
  CONSTRAINT `FKhuvcqbd92kc4eqypgqmyi17cb` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`idpedido`),
  CONSTRAINT `FKpa32yt3hf8rtkx3xeemipfjjb` FOREIGN KEY (`producto_variante_id`) REFERENCES `producto_variante` (`idvariante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_detalle`
--

/*!40000 ALTER TABLE `pedido_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_detalle` ENABLE KEYS */;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso` (
  `idpermiso` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idpermiso`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES (1,'Permite crear nuevos productos','CREAR_PRODUCTO'),(2,'Permite modificar productos existentes','EDITAR_PRODUCTO'),(3,'Permite eliminar productos','ELIMINAR_PRODUCTO'),(4,'Permite visualizar productos','VER_PRODUCTOS'),(5,'Permite gestionar usuarios del sistema','GESTIONAR_USUARIOS'),(6,'Permite gestionar pedidos','GESTIONAR_PEDIDOS'),(7,'Permite gestionar categorias','GESTIONAR_CATEGORIAS'),(8,'Permite gestionar descuentos','GESTIONAR_DESCUENTOS'),(9,'Permite visualizar ventas','VER_VENTAS'),(10,'Permite gestionar envios','GESTIONAR_ENVIOS');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `costo` float NOT NULL,
  `createdat` datetime(6) NOT NULL,
  `descripcion` text,
  `estado` int NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio_max` decimal(10,2) DEFAULT NULL,
  `precio_min` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `categoria_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKodqr7965ok9rwquj1utiamt0m` (`categoria_id`),
  CONSTRAINT `FKodqr7965ok9rwquj1utiamt0m` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`codcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,25,'2026-05-31 00:33:57.000000','Camisa basica de algodon para hombre, manga corta, corte regular',1,NULL,'Seikaze','Camisa Basica Manga Corta',59.90,49.90,100,'2026-05-31 00:33:57.000000',1),(2,30,'2026-05-31 00:33:58.000000','Polo de algodon pima peruano, suave y duradero',1,NULL,'Seikaze','Polo Algodon Pima',69.90,59.90,80,'2026-05-31 00:33:58.000000',1),(3,35,'2026-05-31 00:34:00.000000','Short tipo bermuda en tela gabardina, comodo y fresco',1,NULL,'Seikaze','Short Bermudas',79.90,69.90,60,'2026-05-31 00:34:00.000000',1),(4,45,'2026-05-31 00:34:02.000000','Jean para hombre corte slim fit, elastizado',1,NULL,'Seikaze','Jean Slim Fit',99.90,89.90,50,'2026-05-31 00:34:02.000000',1),(5,60,'2026-05-31 00:34:03.000000','Casaca impermeable con capucha, ideal para lluvia',1,NULL,'Seikaze','Casaca Impermeable',139.90,119.90,40,'2026-05-31 00:34:03.000000',1),(6,28,'2026-05-31 00:34:06.000000','Blusa elegante para mujer, manga larga, tela sedosa',1,NULL,'Seikaze','Blusa Elegante Manga Larga',65.90,55.90,90,'2026-05-31 00:34:06.000000',2),(7,40,'2026-05-31 00:34:07.000000','Vestido estampado floral, ligero y fresco para verano',1,NULL,'Seikaze','Vestido Floral Verano',89.90,79.90,70,'2026-05-31 00:34:07.000000',2),(8,32,'2026-05-31 00:34:07.000000','Falda plisada larga, elastico en cintura, varios colores',1,NULL,'Seikaze','Falda Plisada',74.90,64.90,65,'2026-05-31 00:34:07.000000',2),(9,50,'2026-05-31 00:34:08.000000','Cardigan tejido a mano, lana suave, ideal para invierno',1,NULL,'Seikaze','Cardigan Tejido',119.90,99.90,35,'2026-05-31 00:34:08.000000',2),(10,25,'2026-05-31 00:34:09.000000','Leggins deportivos de compresion, tela breathable',1,NULL,'Seikaze','Leggins Deportivos',59.90,49.90,100,'2026-05-31 00:34:09.000000',2),(11,22,'2026-05-31 00:34:11.000000','Short deportivo con bolsillos, tela rapida',1,NULL,'Seikaze','Short Deportivo Hombre',54.90,44.90,120,'2026-05-31 00:34:11.000000',3),(12,20,'2026-05-31 00:34:12.000000','Top deportivo de alto soporte para entrenamiento',1,NULL,'Seikaze','Top Deportivo Mujer',49.90,39.90,85,'2026-05-31 00:34:12.000000',3),(13,55,'2026-05-31 00:34:13.000000','Buzo polar con cremallera, forro polar suave',1,NULL,'Seikaze','Buzo Polar',129.90,109.90,45,'2026-05-31 00:34:13.000000',3),(14,28,'2026-05-31 00:34:13.000000','Malla deportiva para running, con bolsillo para celular',1,NULL,'Seikaze','Malla Deportiva',65.90,55.90,75,'2026-05-31 00:34:13.000000',3),(15,10,'2026-05-31 00:34:15.000000','Gorra unisex con ajuste trasero, algodon',1,NULL,'Seikaze','Gorra Unisex',29.90,19.90,200,'2026-05-31 00:34:15.000000',4),(16,15,'2026-05-31 00:34:16.000000','Bufanda tejida a mano, lana acrilica',1,NULL,'Seikaze','Bufanda Tejida',39.90,29.90,150,'2026-05-31 00:34:16.000000',4),(17,18,'2026-05-31 00:34:17.000000','Cinturon de cuero genuino, hebilla metalica',1,NULL,'Seikaze','Cinturon Cuero',45.90,35.90,100,'2026-05-31 00:34:17.000000',4),(18,35,'2026-05-31 00:34:18.000000','Mochila urbana 25L, impermeable, compartimento laptop',1,NULL,'Seikaze','Mochila Urbana',89.90,69.90,60,'2026-05-31 00:34:18.000000',4),(19,12,'2026-05-31 00:34:19.000000','Lentes de sol polarizados, proteccion UV400',1,NULL,'Seikaze','Lentes de Sol',34.90,24.90,180,'2026-05-31 00:34:19.000000',4),(20,60,'2026-05-31 00:34:21.000000','Zapatillas urbanas unisex, suela amortiguada',1,NULL,'Seikaze','Zapatillas Urbanas',149.90,119.90,50,'2026-05-31 00:34:21.000000',5),(21,70,'2026-05-31 00:34:22.000000','Zapatos casuales de cuero, suela flexible',1,NULL,'Seikaze','Zapatos Casuales',169.90,139.90,40,'2026-05-31 00:34:22.000000',5),(22,18,'2026-05-31 00:34:26.000000','Sandalias comodas para verano, suela antideslizante',1,NULL,'Seikaze','Sandalias Verano',45.90,35.90,120,'2026-05-31 00:34:26.000000',5),(23,80,'2026-05-31 00:34:27.000000','Botines de cuero forrados, suela antideslizante',1,NULL,'Seikaze','Botines Invierno',189.90,159.90,30,'2026-05-31 00:34:27.000000',5),(24,20,'2026-05-31 00:34:29.000000','Set de body y pantalon para bebe, algodon organico',1,NULL,'Seikaze','Set Baby 2 Piezas',49.90,39.90,80,'2026-05-31 00:34:29.000000',6),(25,15,'2026-05-31 00:34:30.000000','Polera infantil con estampado divertido',1,NULL,'Seikaze','Polera Infantil',39.90,29.90,100,'2026-05-31 00:34:30.000000',6),(26,25,'2026-05-31 00:34:31.000000','Jean para nino/a, elastico en cintura',1,NULL,'Seikaze','Jean Infantil',59.90,49.90,60,'2026-05-31 00:34:31.000000',6),(27,30,'2026-05-31 00:34:32.000000','Chompa tejida para nino/a, lana suave',1,NULL,'Seikaze','Chompa Infantil',69.90,59.90,45,'2026-05-31 00:34:32.000000',6),(28,42,'2026-05-31 00:34:34.000000','Jean clasico de 5 bolsillos, corte regular',1,NULL,'Seikaze','Jean Clasico Hombre',94.90,84.90,70,'2026-05-31 00:34:34.000000',7),(29,40,'2026-05-31 00:34:34.000000','Jean mujer corte skinny, tela elastizada',1,NULL,'Seikaze','Jean Skinny Mujer',89.90,79.90,65,'2026-05-31 00:34:34.000000',7),(30,38,'2026-05-31 00:34:35.000000','Pantalon de gabardina para hombre, corte recto',1,NULL,'Seikaze','Pantalon Gabardina Hombre',85.90,75.90,55,'2026-05-31 00:34:35.000000',7),(31,35,'2026-05-31 00:34:36.000000','Pantalon palazzo mujer, tela fluida y comoda',1,NULL,'Seikaze','Pantalon Palazzo Mujer',79.90,69.90,50,'2026-05-31 00:34:36.000000',7),(32,35,'2026-05-31 00:34:37.000000','Camisa formal para hombre, manga larga, cuello clasico',1,NULL,'Seikaze','Camisa Formal Manga Larga',79.90,69.90,80,'2026-05-31 00:34:37.000000',8),(33,26,'2026-05-31 00:34:38.000000','Blusa casual con volantes, fresca y elegante',1,NULL,'Seikaze','Blusa Casual Mujer',62.90,52.90,75,'2026-05-31 00:34:38.000000',8),(34,38,'2026-05-31 00:34:39.000000','Camisa Oxford de algodon, ideal para oficina',1,NULL,'Seikaze','Camisa Oxford Hombre',85.90,75.90,60,'2026-05-31 00:34:39.000000',8),(35,45,'2026-05-31 00:34:40.000000','Blusa de seda suave, elegante para ocasiones especiales',1,NULL,'Seikaze','Blusa Seda Mujer',109.90,89.90,40,'2026-05-31 00:34:40.000000',8),(36,55,'2026-05-31 00:34:42.000000','Chaqueta de jean clasica para hombre',1,NULL,'Seikaze','Chaqueta Jean Hombre',129.90,109.90,40,'2026-05-31 00:34:42.000000',9),(37,75,'2026-05-31 00:34:43.000000','Abrigo largo para mujer, tela paño, forro interior',1,NULL,'Seikaze','Abrigo Largo Mujer',179.90,149.90,25,'2026-05-31 00:34:43.000000',9),(38,40,'2026-05-31 00:34:43.000000','Chaleco acolchado unisex, ideal para media estacion',1,NULL,'Seikaze','Chaleco Acolchado',89.90,79.90,55,'2026-05-31 00:34:43.000000',9),(39,90,'2026-05-31 00:34:44.000000','Parka de invierno con capucha, forro termico',1,NULL,'Seikaze','Parka Invierno',199.90,179.90,20,'2026-05-31 00:34:44.000000',9),(40,30,'2026-05-31 00:34:46.000000','Vestido casual corto, comodo para el dia a dia',1,NULL,'Seikaze','Vestido Casual',69.90,59.90,60,'2026-05-31 00:34:46.000000',10),(41,65,'2026-05-31 00:34:47.000000','Vestido de noche largo, tela brillante, elegante',1,NULL,'Seikaze','Vestido Noche Largo',159.90,129.90,30,'2026-05-31 00:34:47.000000',10),(42,22,'2026-05-31 00:34:48.000000','Falda corta clasica, varios colores disponibles',1,NULL,'Seikaze','Falda Corta',54.90,44.90,80,'2026-05-31 00:34:48.000000',10),(43,38,'2026-05-31 00:34:48.000000','Vestido midi ajustado, ideal para oficina',1,NULL,'Seikaze','Vestido Midi Fit',85.90,75.90,45,'2026-05-31 00:34:48.000000',10),(44,130,'2026-06-07 17:49:15.500000','1 año de garantia',1,'/uploads/fdfcc7e6-a544-47ca-b9ba-8141526f412a.png','levis','conjunto de ropa',150.00,100.00,10,'2026-06-07 17:49:15.500000',1),(45,130,'2026-06-07 19:05:11.566000','2 años',1,'/uploads/67f82805-1ff2-4508-b620-eed1efa5da6b.png','levis','Polo',150.00,100.00,10,'2026-06-07 19:05:11.566000',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

--
-- Table structure for table `producto_descuento`
--

DROP TABLE IF EXISTS `producto_descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_descuento` (
  `idproducto_descuento` bigint NOT NULL AUTO_INCREMENT,
  `descuento_id` bigint NOT NULL,
  `producto_id` bigint NOT NULL,
  PRIMARY KEY (`idproducto_descuento`),
  KEY `FKodcvepfj9txu8ok2vc02ms17k` (`descuento_id`),
  KEY `FKt161iyy3lxuvj8rfjnihpq2up` (`producto_id`),
  CONSTRAINT `FKodcvepfj9txu8ok2vc02ms17k` FOREIGN KEY (`descuento_id`) REFERENCES `descuento` (`iddescuento`),
  CONSTRAINT `FKt161iyy3lxuvj8rfjnihpq2up` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_descuento`
--

/*!40000 ALTER TABLE `producto_descuento` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_descuento` ENABLE KEYS */;

--
-- Table structure for table `producto_variante`
--

DROP TABLE IF EXISTS `producto_variante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_variante` (
  `idvariante` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `talla` varchar(50) DEFAULT NULL,
  `producto_id` bigint NOT NULL,
  PRIMARY KEY (`idvariante`),
  KEY `FKnu6gl96aegh3x2k2oufr2f3k0` (`producto_id`),
  CONSTRAINT `FKnu6gl96aegh3x2k2oufr2f3k0` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_variante`
--

/*!40000 ALTER TABLE `producto_variante` DISABLE KEYS */;
INSERT INTO `producto_variante` VALUES (1,'Blanco',49.90,20,'S',1),(2,'Blanco',49.90,25,'M',1),(3,'Blanco',49.90,20,'L',1),(4,'Blanco',49.90,15,'XL',1),(5,'Negro',49.90,20,'S',1),(6,'Negro',49.90,25,'M',1),(7,'Negro',49.90,20,'L',1),(8,'Negro',49.90,15,'XL',1),(9,'Azul',49.90,15,'S',1),(10,'Azul',49.90,20,'M',1),(11,'Azul',59.90,15,'L',1),(12,'Azul',59.90,10,'XL',1),(13,'Blanco',59.90,15,'S',2),(14,'Blanco',59.90,20,'M',2),(15,'Blanco',59.90,15,'L',2),(16,'Negro',59.90,15,'S',2),(17,'Negro',59.90,20,'M',2),(18,'Negro',69.90,10,'L',2),(19,'Azul Oscuro',89.90,10,'28',4),(20,'Azul Oscuro',89.90,15,'30',4),(21,'Azul Oscuro',89.90,15,'32',4),(22,'Azul Oscuro',99.90,10,'34',4),(23,'Negro',89.90,10,'30',4),(24,'Negro',89.90,12,'32',4),(25,'Blanco',55.90,15,'S',6),(26,'Blanco',55.90,20,'M',6),(27,'Blanco',65.90,15,'L',6),(28,'Rosado',55.90,12,'S',6),(29,'Rosado',55.90,18,'M',6),(30,'Multicolor',79.90,15,'S',7),(31,'Multicolor',79.90,20,'M',7),(32,'Multicolor',89.90,15,'L',7),(33,'Multicolor',89.90,10,'XL',7),(34,'Blanco',119.90,10,'38',20),(35,'Blanco',119.90,12,'39',20),(36,'Blanco',119.90,15,'40',20),(37,'Blanco',149.90,10,'41',20),(38,'Blanco',149.90,8,'42',20),(39,'Negro',119.90,10,'39',20),(40,'Negro',119.90,12,'40',20),(41,'Negro',149.90,8,'41',20),(42,'Negro',59.90,12,'S',40),(43,'Negro',59.90,15,'M',40),(44,'Negro',69.90,10,'L',40),(45,'Rojo',59.90,10,'S',40),(46,'Rojo',59.90,12,'M',40),(47,'Negro',44.90,15,'S',42),(48,'Negro',44.90,20,'M',42),(49,'Negro',54.90,15,'L',42),(50,'Azul Marino',44.90,12,'S',42),(51,'Azul Marino',44.90,15,'M',42);
/*!40000 ALTER TABLE `producto_variante` ENABLE KEYS */;

--
-- Table structure for table `resena`
--

DROP TABLE IF EXISTS `resena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resena` (
  `idresena` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int NOT NULL,
  `comentario` text,
  `createdat` datetime(6) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `cliente_id` bigint NOT NULL,
  `producto_id` bigint NOT NULL,
  PRIMARY KEY (`idresena`),
  KEY `FK1e5x32riqy66s6nbn1rdnpugo` (`cliente_id`),
  KEY `FK5f27crxa1jnc7wofyw3fiitmc` (`producto_id`),
  CONSTRAINT `FK1e5x32riqy66s6nbn1rdnpugo` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK5f27crxa1jnc7wofyw3fiitmc` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resena`
--

/*!40000 ALTER TABLE `resena` DISABLE KEYS */;
/*!40000 ALTER TABLE `resena` ENABLE KEYS */;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ADMIN'),(2,'CLIENTE');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

--
-- Table structure for table `rol_permiso`
--

DROP TABLE IF EXISTS `rol_permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_permiso` (
  `idrol_permiso` bigint NOT NULL AUTO_INCREMENT,
  `permiso_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`idrol_permiso`),
  KEY `FKfyao8wd0o5tsyem1w55s3141k` (`permiso_id`),
  KEY `FK6o522368i97la9m9cqn0gul2e` (`rol_id`),
  CONSTRAINT `FK6o522368i97la9m9cqn0gul2e` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`idrol`),
  CONSTRAINT `FKfyao8wd0o5tsyem1w55s3141k` FOREIGN KEY (`permiso_id`) REFERENCES `permiso` (`idpermiso`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_permiso`
--

/*!40000 ALTER TABLE `rol_permiso` DISABLE KEYS */;
INSERT INTO `rol_permiso` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1);
/*!40000 ALTER TABLE `rol_permiso` ENABLE KEYS */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `estado` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  `rol_id` bigint DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `FKshkwj12wg6vkm6iuwhvcfpct8` (`rol_id`),
  CONSTRAINT `FKshkwj12wg6vkm6iuwhvcfpct8` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'2026-05-31 00:33:32.000000',1,'$2a$12$2j0Pn/x.2whct1R8t1H16uvCelblRTXB2TlsANpJ2JRidrJUc8XQu','2026-05-31 00:33:32.000000','admin',1),(2,'2026-05-31 00:33:39.000000',1,'$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy','2026-05-31 00:33:39.000000','cliente1',2),(3,'2026-05-31 00:37:30.610000',1,'$2a$10$MzNKh817tiasgItMcSFKu.68Pwjxf5Ufu1b3aEMfyyVVUDuGSn9uW','2026-05-31 00:37:30.610000','Miguel',2),(6,'2026-05-31 01:02:51.874000',1,'$2a$10$303n5uUJ5.Bkyj0iX4iS/OVBLDZoiKMwBF4tuxc.KQofaLzdS9wja','2026-05-31 01:02:51.874000','Sara',2),(7,'2026-05-31 10:41:33.668000',1,'$2a$10$pMgqlAsCqiSbJMPiBdP.G.diMVsvLM60E6HMHlFZFBg33x0DhVQJy','2026-05-31 10:41:33.668000','Kevin',2),(8,'2026-05-31 11:51:47.326000',1,'$2a$10$ZRTFt/.DfedEG51FYjiRVedPPJKuZ/rKuoogKUkT6hHhEkYTFOReS','2026-05-31 11:51:47.326000','Edward',2),(9,'2026-06-04 21:51:43.790000',1,'$2a$10$1lbMNzRhf/b77dw3OXosI.UTnD3NWTkrpw3m3wnRQJIaGHdfqqYoq','2026-06-04 21:51:43.790000','jacob',2),(10,'2026-06-06 20:14:46.696000',1,'$2a$10$J8Tj1YblV9owzBtDeJ0x4eg3XI.B6mhjvw93GBQ8WR7TZEAe3HEUm','2026-06-06 20:14:46.696000','Sarita',2),(11,'2026-06-07 16:47:57.984000',1,'$2a$10$WwNIqFEKPTSmnFLUjHrDMunC1qH.us8cAfU.4xz6uc1.d/0B2dSRS','2026-06-07 16:47:57.984000','Goku',1),(12,'2026-06-07 16:50:40.654000',1,'$2a$10$T.IMPWhi8JbNYgEk5vAHe.bhVoB/HmqnNgS61wfg5mQaxyyOKeo9O','2026-06-07 16:50:40.654000','Bulma',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idventa` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) NOT NULL,
  `createdat` datetime(6) NOT NULL,
  `estado` int NOT NULL,
  `precio_total` decimal(10,2) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  `cliente_id` bigint NOT NULL,
  `pedido_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `FKa7yaj59nfh3gft0h38o5bv472` (`cliente_id`),
  KEY `FK2ux2vsuqvrbl0kompn0jlfitb` (`pedido_id`),
  KEY `FKb28d98ltkhb0f8g3qypy8q2tl` (`usuario_id`),
  CONSTRAINT `FK2ux2vsuqvrbl0kompn0jlfitb` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`idpedido`),
  CONSTRAINT `FKa7yaj59nfh3gft0h38o5bv472` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKb28d98ltkhb0f8g3qypy8q2tl` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

--
-- Table structure for table `venta_detalle`
--

DROP TABLE IF EXISTS `venta_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_detalle` (
  `idventa_detalle` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `producto_variante_id` bigint NOT NULL,
  `venta_id` bigint NOT NULL,
  PRIMARY KEY (`idventa_detalle`),
  KEY `FK7majuoi3f3i8stt4f49ybv576` (`producto_variante_id`),
  KEY `FK49gsk3vfonl3vtivw0xs2w8yt` (`venta_id`),
  CONSTRAINT `FK49gsk3vfonl3vtivw0xs2w8yt` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`idventa`),
  CONSTRAINT `FK7majuoi3f3i8stt4f49ybv576` FOREIGN KEY (`producto_variante_id`) REFERENCES `producto_variante` (`idvariante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_detalle`
--

/*!40000 ALTER TABLE `venta_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_detalle` ENABLE KEYS */;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `idwishlist` bigint NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `updatedat` datetime(6) NOT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`idwishlist`),
  KEY `FKfjffw5jvo70fkrwv2o0jhl10a` (`cliente_id`),
  CONSTRAINT `FKfjffw5jvo70fkrwv2o0jhl10a` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;

--
-- Table structure for table `wishlist_producto`
--

DROP TABLE IF EXISTS `wishlist_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist_producto` (
  `idwishlist_producto` bigint NOT NULL AUTO_INCREMENT,
  `producto_variante_id` bigint NOT NULL,
  `wishlist_id` bigint NOT NULL,
  PRIMARY KEY (`idwishlist_producto`),
  KEY `FKl1e2wsfcpyn5rrp5ucf8tcjw0` (`producto_variante_id`),
  KEY `FKauj7qwji7oxb60dax4mb9ski2` (`wishlist_id`),
  CONSTRAINT `FKauj7qwji7oxb60dax4mb9ski2` FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist` (`idwishlist`),
  CONSTRAINT `FKl1e2wsfcpyn5rrp5ucf8tcjw0` FOREIGN KEY (`producto_variante_id`) REFERENCES `producto_variante` (`idvariante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist_producto`
--

/*!40000 ALTER TABLE `wishlist_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_producto` ENABLE KEYS */;

--
-- Dumping routines for database 'newproject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-07 20:43:46
