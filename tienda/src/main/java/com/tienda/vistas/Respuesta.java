package com.tienda.vistas;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Respuesta {

	private boolean ok;
	private String msg;
	private Object data;
}
