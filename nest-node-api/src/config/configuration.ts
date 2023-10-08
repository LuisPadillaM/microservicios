interface ApiConfigProps {
  apiUrl: string;
  httpTimeout: number;
}
export interface ConfigProps {
  port: number;
  api: ApiConfigProps;
}

export const config = (): ConfigProps => ({
  port: parseInt(process.env.PORT, 10) || 8080,
  api: {
    apiUrl: process.env.API_URL,
    httpTimeout: 1000,
  },
});
