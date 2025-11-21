# Stage 1: Clone source code
FROM alpine/git AS source
WORKDIR /app
RUN git clone https://github.com/DEICONX/pomodoro-app-JS.git .

# Stage 2: Build app
FROM node:18 AS build
WORKDIR /app
COPY --from=source /app /app
RUN npm install && npm run build

# Stage 3: Runtime
FROM node:18-alpine
WORKDIR /app
COPY --from=build /app /app
EXPOSE 3000
CMD ["npm", "start"]
