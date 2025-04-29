package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.service.EmpleadoService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private IClienteMapper clienteMapper;
    private IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteMapper clienteMapper, IClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente clienteRegresado = clienteRepository.save(cliente);
        ClienteDTO clienteDTORegresado = clienteMapper.toDTO(clienteRegresado);

        return clienteDTORegresado;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        for (Cliente c : clientes) {
            clienteDTOs.add(clienteMapper.toDTO(c));
        }
        return clienteDTOs;
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(long id, ClienteDTO clienteDTO) {

    }
}
