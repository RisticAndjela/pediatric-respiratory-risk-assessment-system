param(
    [string]$FrontendPath = "C:\Users\panonit\Documents\sbnz\frontend"
)

$csvPath = Join-Path $FrontendPath "data\demo-children.csv"
if (-not (Test-Path $csvPath)) {
    Write-Error "demo file not found: $csvPath"
    exit 1
}

Write-Output "Demo children already saved in: $csvPath"
Write-Output "You can edit rows here and restart desktop app to reload them."
Get-Content $csvPath
