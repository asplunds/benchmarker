FROM mono:latest
WORKDIR /app
COPY . .
RUN mcs Benchmark.cs
CMD [ "mono", "./Benchmark.exe" ]