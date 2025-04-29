package cua.integra.cajasuamc.service;

public interface ServicioService {
    ClienteDTO save(ClienteDTO clienteDTO);
    List<ClienteDTO> findAll();
    Optional<ClienteDTO> findById(Long id);
    void update(long id, ClienteDTO clienteDTO);
    void deleteById(long id);
}
