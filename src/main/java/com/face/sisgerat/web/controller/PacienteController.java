package com.face.sisgerat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.face.sisgerat.domain.Paciente;
import com.face.sisgerat.domain.Usuario;
import com.face.sisgerat.domain.enums.EstadoCivilEnum;
import com.face.sisgerat.domain.enums.SexoEnum;
import com.face.sisgerat.domain.enums.SituacaoProfissionalEnum;
import com.face.sisgerat.domain.enums.UfEnum;
import com.face.sisgerat.service.PacienteService;
import com.face.sisgerat.service.UsuarioService;

@Controller
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	@Autowired
	private UsuarioService usuarioService;
	
	// abrir pagina de dados pessoais do Paciente
	@GetMapping("/dados")
	public String cadastrar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		paciente = service.buscarPorUsuarioEmail(user.getUsername());
		if (paciente.hasNotId()) {
			paciente.setUsuario(new Usuario(user.getUsername()));
		}
		model.addAttribute("Paciente", paciente);
		return "paciente/cadastro";
	}
	
	// salvar o form de dados pessoais do Paciente com verificacao de senha
	@PostMapping("/salvar")
	public String salvar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(paciente.getUsuario().getSenha(), u.getSenha())) {
			paciente.setUsuario(u);
			service.salvar(paciente);
			model.addAttribute("sucesso", "Seus dados foram inseridos com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "paciente/cadastro";
	}	
	
	// editar o form de dados pessoais do Paciente com verificacao de senha
	@PostMapping("/editar")
	public String editar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(paciente.getUsuario().getSenha(), u.getSenha())) {
			service.editar(paciente);
			model.addAttribute("sucesso", "Seus dados foram editados com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "paciente/cadastro";
	}	
	
//	@ModelAttribute("cargos")
//	public List<Cargo> getCargos() {
//		return cargoService.buscarTodos();
//	}
	
	@ModelAttribute("sexos")
	public SexoEnum[] getSexos() {
		return SexoEnum.values();
	}
	
	@ModelAttribute("estadoCivis")
	public EstadoCivilEnum[] getEstadoCivis() {
		return EstadoCivilEnum.values();
	}
	
	@ModelAttribute("situacoesProfissionais")
	public SituacaoProfissionalEnum[] getSituacoesProfissionais() {
		return SituacaoProfissionalEnum.values();
	}
	@ModelAttribute("ufs")
	public UfEnum[] getUfs() {
		return UfEnum.values();
	}
		
	
}
