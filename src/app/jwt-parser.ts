import { Token } from './../../node_modules/path-to-regexp/dist/index.d';
export function parseJwt(token: string): any {
  try {
    const payload = token.split('.')[1];
    const decoded = atob(payload);
    return JSON.parse(decoded);
  } catch (e) {
    console.error('Invalid token', e);
    return null;
  }
}