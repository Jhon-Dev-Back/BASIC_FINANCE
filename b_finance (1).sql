-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2025 a las 06:44:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `b_finance`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_rol`
--

CREATE TABLE `estado_rol` (
  `idestado_rol` int(11) NOT NULL,
  `estado_rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `estado_rol`
--

INSERT INTO `estado_rol` (`idestado_rol`, `estado_rol`) VALUES
(1, 'Activo'),
(2, 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_suscripcion`
--

CREATE TABLE `estado_suscripcion` (
  `idestado_suscripcion` int(11) NOT NULL,
  `nombre_estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_de_pago`
--

CREATE TABLE `metodo_de_pago` (
  `idmetodo_de_Pago` int(11) NOT NULL,
  `nombre_pago` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL,
  `nombre_pais` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`idpais`, `nombre_pais`) VALUES
(1, 'Colombia'),
(3, 'Mexico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `idperiodo` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_suscripcion`
--

CREATE TABLE `plan_suscripcion` (
  `idplan_suscripcion` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `duracion` int(11) NOT NULL,
  `descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `idreporte` int(11) NOT NULL,
  `monto` decimal(10,0) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` text NOT NULL,
  `tipo_reporte_idtipo_reporte` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_pais_idpais` int(11) NOT NULL,
  `usuario_rol_idrol` int(11) NOT NULL,
  `periodo_idperiodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `nombre_rol` varchar(50) NOT NULL,
  `estado_rol_idestado_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `nombre_rol`, `estado_rol_idestado_rol`) VALUES
(1, 'Administrador', 1),
(2, 'Cliente', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_has_usuario`
--

CREATE TABLE `rol_has_usuario` (
  `rol_idrol` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_pais_idpais` int(11) NOT NULL,
  `usuario_rol_idrol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripcion`
--

CREATE TABLE `suscripcion` (
  `idestado_suscripcion` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_pais_idpais` int(11) NOT NULL,
  `usuario_rol_idrol` int(11) NOT NULL,
  `plan_suscripcion_idplan_suscripcion` int(11) NOT NULL,
  `estado_suscripcion_idestado_suscripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_reporte`
--

CREATE TABLE `tipo_reporte` (
  `idtipo_reporte` int(11) NOT NULL,
  `name_tipo_reporte` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_transaccion`
--

CREATE TABLE `tipo_transaccion` (
  `idTipo_Transaccion` int(11) NOT NULL,
  `estado_transaccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `idTransaccion` int(11) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` text DEFAULT NULL,
  `suscripcion_idestado_suscripcion` int(11) NOT NULL,
  `suscripcion_usuario_idusuario` int(11) NOT NULL,
  `suscripcion_usuario_pais_idpais` int(11) NOT NULL,
  `suscripcion_usuario_rol_idrol` int(11) NOT NULL,
  `suscripcion_plan_suscripcion_idplan_suscripcion` int(11) NOT NULL,
  `suscripcion_estado_suscripcion_idestado_suscripcion` int(11) NOT NULL,
  `tipo_Transaccion_idTipo_Transaccion` int(11) NOT NULL,
  `metodo_de_Pago_idmetodo_de_Pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `identificacion` char(15) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` char(15) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `pais_idpais` int(11) NOT NULL,
  `rol_idrol` int(11) NOT NULL,
  `edad` int(3) DEFAULT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombres`, `apellidos`, `identificacion`, `correo`, `telefono`, `direccion`, `pais_idpais`, `rol_idrol`, `edad`, `contraseña`) VALUES
(8, 'Jhon Deibys', 'Sanabria Torres', '1006903532', 'jhonerrtes1@gmail.com', '3202790419', 'Calle 61b sur ', 1, 1, 24, 'jhon123'),
(10, 'Carlos Mauricio', 'Cordoba', '1126615156', 'mauromash@gmail.com', '3254515155', 'calle 84a@54', 1, 2, 20, 'jhon123'),
(11, 'Lized Dayana', 'Villanueva', '1109264270', 'lized@gmail.com', '3028044158', 'Calle 61b sur # 64b', 1, 2, 20, 'jhon123'),
(12, 'Jaider ', 'Torres', '15151515', 'jader1416@gmail.com', '3214485645', 'Calle 61b sur # 64b', 3, 2, 21, 'jhon123'),
(13, 'Carmen ', 'Torres', '5151515', 'carmen911@gmail.com', '3108719104', 'Calle 61b sur # 64b', 3, 2, 46, 'jhon123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estado_rol`
--
ALTER TABLE `estado_rol`
  ADD PRIMARY KEY (`idestado_rol`),
  ADD UNIQUE KEY `estado_rol` (`estado_rol`);

--
-- Indices de la tabla `estado_suscripcion`
--
ALTER TABLE `estado_suscripcion`
  ADD PRIMARY KEY (`idestado_suscripcion`);

--
-- Indices de la tabla `metodo_de_pago`
--
ALTER TABLE `metodo_de_pago`
  ADD PRIMARY KEY (`idmetodo_de_Pago`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idpais`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`idperiodo`);

--
-- Indices de la tabla `plan_suscripcion`
--
ALTER TABLE `plan_suscripcion`
  ADD PRIMARY KEY (`idplan_suscripcion`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`idreporte`,`tipo_reporte_idtipo_reporte`,`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`,`periodo_idperiodo`),
  ADD KEY `fk_reporte_tipo_reporte1_idx` (`tipo_reporte_idtipo_reporte`),
  ADD KEY `fk_reporte_usuario1_idx` (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`),
  ADD KEY `fk_reporte_periodo1_idx` (`periodo_idperiodo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`),
  ADD KEY `fk_estado_rol` (`estado_rol_idestado_rol`);

--
-- Indices de la tabla `rol_has_usuario`
--
ALTER TABLE `rol_has_usuario`
  ADD PRIMARY KEY (`rol_idrol`,`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`),
  ADD KEY `fk_rol_has_usuario_usuario1_idx` (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`),
  ADD KEY `fk_rol_has_usuario_rol1_idx` (`rol_idrol`);

--
-- Indices de la tabla `suscripcion`
--
ALTER TABLE `suscripcion`
  ADD PRIMARY KEY (`idestado_suscripcion`,`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`,`plan_suscripcion_idplan_suscripcion`,`estado_suscripcion_idestado_suscripcion`),
  ADD KEY `fk_suscripcion_usuario1_idx` (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`),
  ADD KEY `fk_suscripcion_plan_suscripcion1_idx` (`plan_suscripcion_idplan_suscripcion`),
  ADD KEY `fk_suscripcion_estado_suscripcion1_idx` (`estado_suscripcion_idestado_suscripcion`);

--
-- Indices de la tabla `tipo_reporte`
--
ALTER TABLE `tipo_reporte`
  ADD PRIMARY KEY (`idtipo_reporte`);

--
-- Indices de la tabla `tipo_transaccion`
--
ALTER TABLE `tipo_transaccion`
  ADD PRIMARY KEY (`idTipo_Transaccion`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`idTransaccion`,`suscripcion_idestado_suscripcion`,`suscripcion_usuario_idusuario`,`suscripcion_usuario_pais_idpais`,`suscripcion_usuario_rol_idrol`,`suscripcion_plan_suscripcion_idplan_suscripcion`,`suscripcion_estado_suscripcion_idestado_suscripcion`,`tipo_Transaccion_idTipo_Transaccion`,`metodo_de_Pago_idmetodo_de_Pago`),
  ADD KEY `fk_Transaccion_suscripcion1_idx` (`suscripcion_idestado_suscripcion`,`suscripcion_usuario_idusuario`,`suscripcion_usuario_pais_idpais`,`suscripcion_usuario_rol_idrol`,`suscripcion_plan_suscripcion_idplan_suscripcion`,`suscripcion_estado_suscripcion_idestado_suscripcion`),
  ADD KEY `fk_Transaccion_tipo_Transaccion1_idx` (`tipo_Transaccion_idTipo_Transaccion`),
  ADD KEY `fk_Transaccion_metodo_de_Pago1_idx` (`metodo_de_Pago_idmetodo_de_Pago`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`,`pais_idpais`,`rol_idrol`),
  ADD UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  ADD KEY `fk_usuario_pais_idx` (`pais_idpais`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado_rol`
--
ALTER TABLE `estado_rol`
  MODIFY `idestado_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `estado_suscripcion`
--
ALTER TABLE `estado_suscripcion`
  MODIFY `idestado_suscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `metodo_de_pago`
--
ALTER TABLE `metodo_de_pago`
  MODIFY `idmetodo_de_Pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idpais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `periodo`
--
ALTER TABLE `periodo`
  MODIFY `idperiodo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plan_suscripcion`
--
ALTER TABLE `plan_suscripcion`
  MODIFY `idplan_suscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `idreporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `suscripcion`
--
ALTER TABLE `suscripcion`
  MODIFY `idestado_suscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_reporte`
--
ALTER TABLE `tipo_reporte`
  MODIFY `idtipo_reporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_transaccion`
--
ALTER TABLE `tipo_transaccion`
  MODIFY `idTipo_Transaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `idTransaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `fk_reporte_periodo1` FOREIGN KEY (`periodo_idperiodo`) REFERENCES `mydb`.`periodo` (`idperiodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reporte_tipo_reporte1` FOREIGN KEY (`tipo_reporte_idtipo_reporte`) REFERENCES `mydb`.`tipo_reporte` (`idtipo_reporte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reporte_usuario1` FOREIGN KEY (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`) REFERENCES `mydb`.`usuario` (`idusuario`, `pais_idpais`, `rol_idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `fk_estado_rol` FOREIGN KEY (`estado_rol_idestado_rol`) REFERENCES `estado_rol` (`idestado_rol`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `rol_has_usuario`
--
ALTER TABLE `rol_has_usuario`
  ADD CONSTRAINT `fk_rol_has_usuario_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `mydb`.`rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rol_has_usuario_usuario1` FOREIGN KEY (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`) REFERENCES `mydb`.`usuario` (`idusuario`, `pais_idpais`, `rol_idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `suscripcion`
--
ALTER TABLE `suscripcion`
  ADD CONSTRAINT `fk_suscripcion_estado_suscripcion1` FOREIGN KEY (`estado_suscripcion_idestado_suscripcion`) REFERENCES `mydb`.`estado_suscripcion` (`idestado_suscripcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_suscripcion_plan_suscripcion1` FOREIGN KEY (`plan_suscripcion_idplan_suscripcion`) REFERENCES `mydb`.`plan_suscripcion` (`idplan_suscripcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_suscripcion_usuario1` FOREIGN KEY (`usuario_idusuario`,`usuario_pais_idpais`,`usuario_rol_idrol`) REFERENCES `mydb`.`usuario` (`idusuario`, `pais_idpais`, `rol_idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `fk_Transaccion_metodo_de_Pago1` FOREIGN KEY (`metodo_de_Pago_idmetodo_de_Pago`) REFERENCES `mydb`.`metodo_de_pago` (`idmetodo_de_Pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Transaccion_suscripcion1` FOREIGN KEY (`suscripcion_idestado_suscripcion`,`suscripcion_usuario_idusuario`,`suscripcion_usuario_pais_idpais`,`suscripcion_usuario_rol_idrol`,`suscripcion_plan_suscripcion_idplan_suscripcion`,`suscripcion_estado_suscripcion_idestado_suscripcion`) REFERENCES `mydb`.`suscripcion` (`idestado_suscripcion`, `usuario_idusuario`, `usuario_pais_idpais`, `usuario_rol_idrol`, `plan_suscripcion_idplan_suscripcion`, `estado_suscripcion_idestado_suscripcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Transaccion_tipo_Transaccion1` FOREIGN KEY (`tipo_Transaccion_idTipo_Transaccion`) REFERENCES `mydb`.`tipo_transaccion` (`idTipo_Transaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_pais` FOREIGN KEY (`pais_idpais`) REFERENCES `pais` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
