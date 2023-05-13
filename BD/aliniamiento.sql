-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla aliniamiento.encuesta
CREATE TABLE IF NOT EXISTS `encuesta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario_id` int unsigned NOT NULL,
  `nombre_encuesta` int unsigned NOT NULL,
  `codigo_encuesta` int unsigned NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_encuesta` (`usuario_id`),
  CONSTRAINT `FK_usuario_encuesta` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla aliniamiento.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombreapellido` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL DEFAULT '0',
  `carrera` varchar(120) COLLATE utf8mb4_spanish_ci NOT NULL DEFAULT '0',
  `correo` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL DEFAULT '0',
  `ciclo` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla aliniamiento.preguntas_encuesta
CREATE TABLE IF NOT EXISTS `preguntas_encuesta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `encuesta_id` int unsigned NOT NULL,
  `usuario_id` int unsigned NOT NULL,
  `pregunta` text COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_preguntas` (`usuario_id`),
  KEY `FK_encuesta_preguntas` (`encuesta_id`),
  CONSTRAINT `FK_encuesta_preguntas` FOREIGN KEY (`encuesta_id`) REFERENCES `encuesta` (`id`),
  CONSTRAINT `FK_usuario_preguntas` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla aliniamiento.repuesta_encuesta
CREATE TABLE IF NOT EXISTS `repuesta_encuesta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario_id` int unsigned NOT NULL,
  `pregunta_encuesta_id` int unsigned NOT NULL,
  `repuesta` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_respuesta` (`usuario_id`),
  KEY `FK_preguntas_respuestas` (`pregunta_encuesta_id`),
  CONSTRAINT `FK_preguntas_respuestas` FOREIGN KEY (`pregunta_encuesta_id`) REFERENCES `preguntas_encuesta` (`id`),
  CONSTRAINT `FK_usuario_respuesta` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla aliniamiento.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `rol` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla aliniamiento.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int unsigned NOT NULL,
  `rol_id` int unsigned NOT NULL,
  `persona_id` int unsigned NOT NULL,
  `usuario` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `password` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rol_usuario` (`rol_id`),
  KEY `FK_persona_usuario` (`persona_id`),
  CONSTRAINT `FK_persona_usuario` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK_rol_usuario` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
