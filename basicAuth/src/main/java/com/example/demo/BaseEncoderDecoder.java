/**
 * 
 */
package com.example.demo;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Component;

/**
 * @author ntanwa
 *
 */
@Component
public class BaseEncoderDecoder {

	private Encoder encoder;
	
	private Decoder decoder;
	
	
	/**
	 * @param encoder
	 * @param decoder
	 */
	public BaseEncoderDecoder() {
		this.encoder = Base64.getEncoder();
		this.decoder = Base64.getDecoder();
	}

	/**
	 * @param encodedStr
	 */
	public String decode(String encodedStr) {
		String decodeStr = new String(decoder.decode(encodedStr.getBytes()));
		return decodeStr;
	}

	/**
	 * @param message
	 * @return
	 */
	public String encode(String message) {
		String encodedStr = encoder.encodeToString(message.getBytes());
		return encodedStr;
	}

}
