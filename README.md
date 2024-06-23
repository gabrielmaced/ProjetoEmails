Sistema de Envio de Emails

O sistema é um Projeto Spring Boot

Para compilar foi utilizado o Maven, logo para executar é só abrir a pasta do Projeto:
cd ProjetoDeEmails

Depois compile e execute com o comando:
mvn spring-boot:run

Para realizar testes foi utilizado o Postman para cadastrar os clientes e as noticias e o Docker para verificar se os emails estavam sendo encaminhados via MailHog

Com o Docker ja instalado execute o comando:
docker run -d -p 1025:1025 -p 8025:8025 mailhog/mailhog

Este comando executará o MailHog em segundo plano (-d) e mapeará a porta 1025 para SMTP e a porta 8025 para a interface web.
Abra um navegador e acesse http://localhost:8025. Você deve ver a interface web do MailHog.

Após esses passos o programa irá enviar os emails com as noticias para os clientes seguindo o horário programado em service/EmailService.java(linha 26).

O email que enviará as noticias é o host do docker

Para cadastro de cliente no Postman acesse http://localhost:8080/api/clientes
Modelo cadastro de Cliente
Pode ou nao ter nascimento
{
    "nome": "Joao",
    "email": "joao@gmail.com",
    "nascimento": "1998-06-25" 
}
Para cadastro de cliente no Postman acesse http://localhost:8080/api/noticias
Modelo cadastro de Noticia
Pode ou nao ter link
{
    "titulo": "Sorteio",
    "descricao": "Bilhete da Sorte",
    "link": "sorteio.com.br"
}



"# ProjetoEmails" 
