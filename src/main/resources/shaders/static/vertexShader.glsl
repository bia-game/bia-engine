#version 330 core

in vec3 position;
in vec2 textureCoords;

out vec3 outColour;
out vec2 outTextureCoords;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main(void) {
    gl_Position = projectionMatrix * viewMatrix * transformationMatrix * vec4(position, 1.0);
    outTextureCoords = textureCoords;
    outColour = vec3(position.x + 0.5, 0.0, position.y + 0.5);
}
