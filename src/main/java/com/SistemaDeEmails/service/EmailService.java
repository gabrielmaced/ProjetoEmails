package com.SistemaDeEmails.service;

import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.SistemaDeEmails.Entidade.Cliente;
import com.SistemaDeEmails.Entidade.Noticia;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private NoticiaService noticiaService;

    @Scheduled(cron = "0 14 18 * * ?")//ALTERE AQUI A DATA E HORA QUE OS EMAILS SERÃO ENVIADOS(legenda "0 33 15 * * ?" =(segundo minuto hora diaDoMes Mes diaDaSemana))
    public void enviarNoticiasDiarias() {
        List<Cliente> clientes = clienteService.buscarTodosClientes();
        List<Noticia> noticias = noticiaService.buscarNoticiasNaoProcessadas();

        if(noticiaService != null)
            if(noticias.isEmpty()){     // Verifica se há noticias cadastradas no dia.
                return;
            }

            for (Cliente cliente : clientes) {
                // Verificação de Aniversário do Cliente
                LocalDate dataAtual = LocalDate.now();
                int diaAtual = dataAtual.getDayOfMonth();
                int mesAtual = dataAtual.getMonthValue();
                LocalDate nascimentoCliente = cliente.getNascimento();
                int diaNascimento = nascimentoCliente.getDayOfMonth();
                int mesNascimento = nascimentoCliente.getMonthValue();

                boolean aniversariante = false;

                if (nascimentoCliente != null && diaNascimento == diaAtual && mesNascimento == mesAtual) {
                    aniversariante = true;
                }

                enviarEmail(cliente, noticias, aniversariante);
            }

            marcarNoticiasComoProcessadas(noticias);
    }

    private void enviarEmail(Cliente cliente, List<Noticia> noticias, boolean aniversariante) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(cliente.getEmail());
            helper.setSubject("Notícias do dia!");
    
            StringBuilder corpo = new StringBuilder();
            corpo.append("Bom dia ").append(cliente.getNome()).append("! ");

            if (aniversariante) {
                corpo.append("Feliz aniversário!");
            }

            corpo.append("<p>Segue as notícias de hoje:</p>");


            for (Noticia noticia : noticias) {
                corpo.append("<p>");

                if (noticia.getLink() != null) {
                    corpo.append("<h3><a href=\"")
                         .append(noticia.getLink())
                         .append("\">")
                         .append(noticia.getTitulo())
                         .append("</a></h3>");
                } else {
                    corpo.append("<h3>")
                    .append(noticia.getTitulo())
                    .append("</h3>");
                }
                corpo.append(noticia.getDescricao()).append("</p></br>");
            }
    
            corpo.append("<p>Até a próxima.</p>");
    
            helper.setText(corpo.toString(), true); // true indica que o conteúdo é HTML
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Lidar com a exceção
            e.printStackTrace();
        }
    }

    private void marcarNoticiasComoProcessadas(List<Noticia> noticias) {
        for (Noticia noticia : noticias) {
            noticia.setProcessada(true);
            noticiaService.cadastrarNoticia(noticia);
        }
    }
    
}
