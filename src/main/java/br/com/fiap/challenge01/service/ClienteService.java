package br.com.fiap.challenge01.service;

import br.com.fiap.challenge01.dto.ClienteDTO;
import br.com.fiap.challenge01.model.Cliente;
import br.com.fiap.challenge01.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    public void cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Integer id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setDataRegistro(clienteDTO.getDataRegistro());
            clienteRepository.save(cliente);
        }
    }

    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
