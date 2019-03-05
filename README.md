# POC-Sistema de Controle Logístico

PUC Minas EAD

Trabalho de Conclusão do curso de Arquitetura de Software Distribuído 


A POC deverá validar o protótipo arquitetural. Serão avaliados os seguintes atributos de qualidade: segurança, desempenho e interoperabilidade.

### Divisão do projeto ###

A solução é composta de 3 aplicações:

- **sislog:** Módulo backend do sistema da transportadora que disponibiliza serviços para serem consumidos por outros sistemas e pelo frontend.
- **eurekaapp:** Sistema que atuará como service discovery 
- **zullapp:** Sistema que atuará como gateway service. Será responsável pelo roteamento dos serviços, segurança e balanceamento de carga.

**Obs:** Apesar de ser mencionado o módulo de frontend no projeto arquitetural, o módulo não foi desenvolvido por entender que para a validação não seria muito relevante.

### Tecnologias envolvidas na solução ###
 
Toda a solução será desenvolvida na linguagem JAVA=, com a utilização das plataformas Spring e Netflix OSS.
As seguintes tecnologias foram utilizadas:

O módulo frontend: 

- Thymeleaf para gerenciamento de templates web; 
- Bootstrap e JQuery para tornar as páginas responsivas e com componentes ricos; 
- Jasper Reports para geração de relatórios; 
- Spring MVC para criação de aplicação web com implementação do padrão MVC (Model-view-controller).


O módulo de serviços **(sislog)**: 

- Spring Boot; 
- Spring Data para mapeamento Objeto Relacional utilizando especificação JPA; 
- Google Maps Service para acessar a API Matrix Distance que auxiliará no caso de uso de calculo do frete.


Para atender alguns requisitos não funcionais foram acrescentados:

	Segurança: 
	- Spring Security para fazer a autenticação e autorização de usuários; 
	- Padrão JWT (JSON Web Tokens) para transmissão de objetos JSON de forma segura e compacta entre diferentes aplicações.

	Interoperabilidade: 
	- Modelo de arquitetura REST para construção de Web Services.
	
	Desempenho:
	- EUREKA (Service Discovery);
	- ZUUL (Gateway Service) garantindo o balanceamento de carga.