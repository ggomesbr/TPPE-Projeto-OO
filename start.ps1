# Script PowerShell para executar o projeto completo
Write-Host "🚀 Executando projeto completo com testes..." -ForegroundColor Green
Write-Host ""
Write-Host "Isso vai:" -ForegroundColor Yellow
Write-Host "1. Subir o banco de dados (aguarda ficar saudável)" -ForegroundColor White
Write-Host "2. Executar os testes automaticamente" -ForegroundColor White
Write-Host "3. Subir o backend (apenas se os testes passarem)" -ForegroundColor White
Write-Host ""
Write-Host "⏳ Aguarde... (pode demorar na primeira execução)" -ForegroundColor Cyan
Write-Host ""
Write-Host "💡 Se der erro de conexão, execute: .\clean-start.ps1" -ForegroundColor Gray
Write-Host ""

docker-compose up --build

Write-Host ""
Write-Host "Para parar tudo: docker-compose down -v" -ForegroundColor Yellow
