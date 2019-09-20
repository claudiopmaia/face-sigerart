package com.face.sisgerat.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.face.sisgerat.domain.Cidade;

@Component
public class CidadeConverter implements Converter<String[], List<Cidade>>{

	@Override
	public List<Cidade> convert(String[] source) {
		List<Cidade> cdiades = new ArrayList<>();
		for (String id : source) {
			if (!id.equals("0")) {
				cdiades.add(new Cidade(Long.parseLong(id)));
			}
		}
		return cdiades;
	}
}
