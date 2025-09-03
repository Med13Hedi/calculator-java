# 🚂 Railway Deployment Guide

> **Railway** is a modern deployment platform that makes it easy to deploy and manage applications with zero configuration.

## 📋 Table of Contents

- [🔑 Setup and Authentication](#-setup-and-authentication)
- [🚀 Deployment Commands](#-deployment-commands)
- [📊 Management and Monitoring](#-management-and-monitoring)
- [🏗️ Project Management](#️-project-management)
- [🔧 Environment and Variables](#-environment-and-variables)
- [🔍 Troubleshooting](#-troubleshooting)
- [💡 Best Practices](#-best-practices)

---

## 🔑 Setup and Authentication

Start by authenticating and setting up your Railway project:

```bash
# Login to your Railway account
railway login

# Initialize a new project in current directory
railway init

# Link to an existing project (if you have one)
railway link [project-id]
```

---

## 🚀 Deployment Commands

### Recommended Deployment (Non-blocking)

```bash
# Deploy in background (recommended for production)
railway up --detach

# Deploy in CI mode (non-interactive, perfect for automation)
railway up --ci

# Alternative deploy command
railway deploy
```

> **💡 Tip:** Use `--detach` flag for production deployments to avoid blocking your terminal.

---

## 📊 Management and Monitoring

Keep track of your deployments and monitor performance:

```bash
# Check current deployment status
railway status

# View application logs
railway logs

# Follow logs in real-time (useful for debugging)
railway logs --tail

# Get or generate your deployment URL
railway domain

# Open your deployed app in browser
railway open
```

---

## 🏗️ Project Management

Manage your Railway projects and services:

```bash
# List all your projects
railway projects

# List services in current project
railway services

# Stop or cancel current deployment
railway down
```

---

## 🔧 Environment and Variables

Configure your application environment:

```bash
# Set environment variables
railway env set KEY=value

# View current environment variables
railway variables
```

### Example: Setting Database URL

```bash
railway env set DATABASE_URL=postgresql://user:pass@host:port/db
railway env set NODE_ENV=production
```

---

## 🔍 Troubleshooting

Debug and diagnose issues:

```bash
# Check which user is currently logged in
railway whoami

# Open interactive shell with Railway environment
railway shell

# Run commands with Railway environment variables
railway run [command]
```

**Troubleshooting hanging deployments:**
```bash
# If terminal hangs, open a NEW terminal and run:
railway status          # Check if deployment is actually running
railway logs            # View logs to see progress
railway logs --tail     # Follow logs in real-time

# If deployment is stuck, you can:
railway down            # Cancel the deployment
railway up --detach     # Try again in detached mode
```

**If `railway up` hangs, try these alternatives:**
```bash
# Option 1: Use detached mode (recommended)
railway up --detach

# Option 2: Use CI mode (non-interactive)
railway up --ci

# Option 3: If still hanging, cancel (Ctrl+C) and try:
railway deploy

# Check deployment status
railway status

# View deployment logs (in separate terminal if needed)
railway logs --tail

# Get the deployment URL
railway domain

# Open the deployed app
railway open
```

### Common Issues

| Issue | Solution |
|-------|----------|
| Authentication failed | Run `railway login` again |
| Deployment stuck | Use `railway up --detach` instead |
| Environment variables not loading | Check with `railway variables` |
| Can't access logs | Ensure you're in the correct project directory |

---

## 💡 Best Practices

### ✅ Do's

- Always use `railway up --detach` for production deployments
- Monitor logs regularly with `railway logs --tail`
- Set environment variables before deploying
- Use meaningful project names during initialization

### ❌ Don'ts

- Don't commit sensitive environment variables to version control
- Avoid using blocking deployment commands in CI/CD pipelines
- Don't forget to check deployment status after deploying

---

## 📚 Additional Resources

- [Railway Documentation](https://docs.railway.app/)
- [Railway Templates](https://railway.app/templates)
- [Railway Discord Community](https://discord.gg/railway)

---

**Happy Deploying! 🎉**
