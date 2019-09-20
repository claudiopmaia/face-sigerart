package com.face.sisgerat.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.face.sisgerat.domain.Uf;

@Component
public class UfConverter implements Converter<String[], List<Uf>>{

	@Override
	public List<Uf> convert(String[] source) {
		List<Uf> ufs = new ArrayList<>();
		for (String id : source) {
			if (!id.equals("0")) {
				ufs.add(new Uf(Long.parseLong(id)));
			}
		}
		return ufs;
	}
}
