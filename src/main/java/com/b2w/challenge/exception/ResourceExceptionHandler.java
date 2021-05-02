package com.b2w.challenge.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
				HttpStatus.NOT_FOUND.value(), "Não encontrado!", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {
		StandardError err = new StandardError(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
				HttpStatus.BAD_REQUEST.value(), "Informações inválidas!", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<StandardError> badRequest(ServiceUnavailableException e, HttpServletRequest request) {
		StandardError err = new StandardError(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
				HttpStatus.BAD_REQUEST.value(), "Service SW Api indisponível.", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MongoWriteException.class)
	public ResponseEntity<StandardError> badRequest(MongoWriteException e, HttpServletRequest request) {
		StandardError err = new StandardError(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
				HttpStatus.BAD_REQUEST.value(), "Informações inválidas!",
				"Já existe um planeta cadastrado com este nome.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
