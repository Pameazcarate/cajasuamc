package cua.integra.cajasuamc.service;

public interface EmpleadoService {
    ClienteDTO save(ClienteDTO clienteDTO);
    List<ClienteDTO> findAll();
    Optional<ClienteDTO> findById(Long id);
    void update(long id, ClienteDTO clienteDTO);
    void deleteById(long id);
}
