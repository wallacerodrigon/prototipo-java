export enum AuthMethod {
  NONE,
  KEYCLOAK
}

export const environment = {
  production: true,
  api: 'https://reqres.in/api',
  auth_method: AuthMethod.NONE,
  client_name: 'TRF - 1ª Região',
  system_name: 'EAVS',
  system_version: '1.11.1',
  theme: 'ebonyClay',
  themeAutoContraste: 'ebonyClayAutoContraste',
  keycloak: {
    script: null,
    logoutUrl: null,
    redirect_uri: null,
    config: null
  }
};
