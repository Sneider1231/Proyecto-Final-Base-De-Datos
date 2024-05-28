import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Administracion from '../views/Administracion.vue'
import BuscarVehiculo from '../views/BuscarVehiculo.vue'
import AgregarVehiculo from '../views/AgregarVehiculo.vue'
import Login from '../views/Login.vue'
import ModificarDatos from '../views/ModificarDatos.vue'
import PaginaPrincipal from '../views/PaginaPrincipal.vue'
import VerTodos from '../views/VerTodos.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/inicio'
  },
  {
    path: '/admin',
    redirect: '/admin/login'
  },
  {
    path: '/admin/inicio',
    name: 'Inicio de Administración',
    component: Administracion
  },
  {
    path: '/buscar',
    name: 'Búsqueda',
    component: BuscarVehiculo
  },
  {
    path: '/admin/modificar',
    name: 'Modificar datos',
    component: ModificarDatos
  },
  {
    path: '/admin/agregar',
    name: 'Agregar Vehículo',
    component: AgregarVehiculo
  },
  {
    path: '/admin/login',
    name: 'Iniciar sesión',
    component: Login
  },
  {
    path: '/inicio',
    name: 'Página Principal',
    component: PaginaPrincipal
  },
  {
    path: '/todos',
    name: 'Todos los Vehículos',
    component: VerTodos
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
