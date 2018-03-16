// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export enum AuthMethod {
  NONE,
  KEYCLOAK
}

export const environment = {
  production: false,
  api: 'https://localhost:8080/api/rest/',
  auth_method: AuthMethod.NONE,
  client_name: 'TRF - 1ª Região',
  system_name: 'STUB',
  system_version: '1.0.1-SNAPSHOT',
  theme: 'ebonyClay',
  themeAutoContraste: 'ebonyClayAutoContraste',
  keycloak: {
    script: null,
    logoutUrl: null,
    redirect_uri: null,
    config: null
  }
};
