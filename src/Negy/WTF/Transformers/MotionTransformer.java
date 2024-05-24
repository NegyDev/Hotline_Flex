package Negy.WTF.Transformers;

import org.objectweb.asm.*;

public class MotionTransformer {
    public static byte[] TransformClient(byte[] originalBytes)
    {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM6, classWriter)
        {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor original_mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
                if (name.equals("K") && descriptor.equals("()V"))
                {
                    return new MethodVisitor(Opcodes.ASM6, original_mv) {
                        @Override
                        public void visitCode()
                        {
                            mv.visitTypeInsn(Opcodes.NEW, "Negy/WTF/Event/impl/MotionEvent");
                            mv.visitInsn(Opcodes.DUP);
                            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "Negy/WTF/Event/impl/MotionEvent", "<init>", "()V", false);
                            mv.visitVarInsn(Opcodes.ASTORE, 19);
                            mv.visitVarInsn(Opcodes.ALOAD, 19);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "Negy/WTF/module/Module", "onEventAdd", "(LNegy/WTF/Event/Event;)V", false);
                            mv.visitCode();

                        }
                    };
                }
                return original_mv;
            }
        };

        ClassReader classReader = new ClassReader(originalBytes);
        classReader.accept(classVisitor, 0);
        return classWriter.toByteArray();
    }
}
