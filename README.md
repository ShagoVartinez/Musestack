MUSESTACK

La secretaria de cultura del Departamento X quiere promover, difundir el arte y apoyar a los artistas del departamento. Para ello requiere de una aplicación con las siguientes funcionalidades:
•	Desde una plataforma Administrador se deben organizar eventos artísticos enfocados a un género especifico en los que se expongan pinturas de diferentes artistas, este evento debe tener un nombre, fecha de inicio y fecha de finalización y la galería en la que será realizado. Para esto debe haber un filtro de Pinturas por genero artístico para facilitar al administrador organizar el evento.

•	Desde una plataforma usuario se verá la información de los eventos que se realizarán en las diferentes galerías. Además, los usuarios podrán dar una calificación y crítica a las obras de los artistas. Esta plataforma debe ser manejada como plataforma móvil.


•	Desde una plataforma Artista, Los artistas registrados podrán actualizar la información de sus obras (Agregar obras, cambiar estado vendida o no) y ver si están invitados a un evento.

De los Artistas, Usuarios y Administrador se debe tener la siguiente información: N° de documento de identificación, Nombre(s), Apellidos, Correo electrónico, N° de teléfono y una contraseña para el ingreso a la aplicación. Además, del artista se debe tener su foto, su Dirección y la lista de géneros artísticos a los cuales este pertenece (Esta lista se deduce del género artístico de sus pinturas).
Las pinturas deben tener: Nombre, Imagen, Tamaño (Ancho, Alto), Año, Genero artístico, Precio, Estado (Vendida o no), una calificación dada por los usuarios (0-5) y una critica también dada por él usuario.
Se debe tener una base de datos de Galerías con: Nombre, Ciudad, Dirección, Teléfono de contacto, Estado (Ocupada o Libre).
Los eventos deben tener la lista de artistas que participan y la lista de obras presentadas. No se deben presentar obras cuyo estado sea vendido.
Los datos de los usuarios deben ser extraídos de un archivo de texto y los datos del administrador de un archivo binario.
La información de las galerías será extraída de web en XML o JSON.
Para el ingreso de los usuarios, artistas y administrador se debe hacer desde un login y también se debe permitir que se creen nuevos usuarios y artistas y esta información será escrita en el respectivo archivo que guarda los datos de estas dos entidades.
La aplicación debe contar con multilenguaje (inglés y español).



Los reportes que se deben mostrar son.
•	Gráfico de barras con cantidad de artistas por genero artístico (Plataforma administrador).
•	Gráfico de barras con cantidad de obras por genero (Plataforma administrador).
•	Gráfico de dispersión cantidad de eventos realizados en cierta galería en los últimos 5 años (Plataforma administrador).
•	Top 5 artistas mejor calificados (Plataforma usuario).
•	Top 5 obras mejor calificadas (Plataforma usuario).
•	Gráfico de dispersión cantidad de eventos a los que ha sido invitado el artista en los últimos 6 meses. (Plataforma artista).
•	Obra mejor calificada (Plataforma artista).
•	Gráfico de dispersión cantidad de obras realizadas en los últimos 5 años.

Filtros
•	Filtro de galerías por estado para realizar evento
•	Filtro de obras por género y estado para incluirlas en un evento
•	Filtro de autores para realizar calificación de sus obras.
