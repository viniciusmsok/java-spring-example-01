package br.com.vanguardasistemas.adapter.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.port.api.RootAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Root", description = "API root endpoint")
@RestController
public class RootRest implements RootAPI {

  @Override
  @Operation(
    summary = "Get root page",
    description = "Returns HTML page with links to Swagger documentation and Health Check."
  )
  public ResponseEntity<String> getRoot() {
    String htmlContent = """
        <!DOCTYPE html>
        <html lang="pt-BR">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Payment Slip API</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    max-width: 800px;
                    margin: 50px auto;
                    padding: 20px;
                    background-color: #f5f5f5;
                }
                .container {
                    background-color: white;
                    padding: 30px;
                    border-radius: 10px;
                    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                }
                h1 {
                    color: #333;
                    text-align: center;
                    margin-bottom: 30px;
                }
                .links {
                    display: flex;
                    flex-direction: column;
                    gap: 20px;
                }
                .link-card {
                    padding: 20px;
                    border: 2px solid #007bff;
                    border-radius: 8px;
                    text-decoration: none;
                    color: #007bff;
                    transition: all 0.3s ease;
                    text-align: center;
                }
                .link-card:hover {
                    background-color: #007bff;
                    color: white;
                    transform: translateY(-2px);
                }
                .link-card h2 {
                    margin: 0 0 10px 0;
                    font-size: 1.5em;
                }
                .link-card p {
                    margin: 0;
                    opacity: 0.8;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <h1>🚀 Payment Slip API</h1>
                <div class="links">
                    <a href="/swagger-ui/index.html" class="link-card">
                        <h2>📚 Swagger Documentation</h2>
                        <p>API Documentation</p>
                    </a>
                    <a href="/health-check" class="link-card">
                        <h2>💚 Health Check</h2>
                        <p>Application Health Check</p>
                    </a>
                </div>
            </div>
        </body>
        </html>
        """;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_HTML);

    return ResponseEntity.ok()
        .headers(headers)
        .body(htmlContent);
  }
} 