package com.exemplo.sislog.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemplo.sislog.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
//    Optional<Pedido> findById(Long id);
//@Query("select p from Pedido p inner join p.cargas c inner join c.notaFiscal f left outer join p.eventos where LOWER(p.empresaEntrega.cnpj) =LOWER(:cnpjEmpresaDestino) and LOWER(f.numeroNotaFiscal)=LOWER(:numeroNotaFiscal) and f.dataEmissao=:dataEmissao")	
@Query(" from Pedido p inner join p.carga c inner join fetch  p.eventos e where LOWER(p.empresaEntrega.cnpj) =LOWER(:cnpjEmpresaDestino) and LOWER(c.notaFiscal.numeroNotaFiscal)=LOWER(:numeroNotaFiscal) and c.notaFiscal.dataEmissao=:dataEmissao")	
public Pedido consultarSituacaoServico(@Param("cnpjEmpresaDestino")String cnpjEmpresaDestino, @Param("numeroNotaFiscal")String numeroNotaFiscal, @Param("dataEmissao")Date dataEmissao );
}
